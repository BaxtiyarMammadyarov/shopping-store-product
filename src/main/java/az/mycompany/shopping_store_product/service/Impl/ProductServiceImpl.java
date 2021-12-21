package az.mycompany.shopping_store_product.service.Impl;

import az.mycompany.shopping_store_product.client.BookClient;
import az.mycompany.shopping_store_product.dto.Book;
import az.mycompany.shopping_store_product.dto.ProductDto;
import az.mycompany.shopping_store_product.entity.ProductEntity;
import az.mycompany.shopping_store_product.entity.ProductType;
import az.mycompany.shopping_store_product.repository.ProductRepository;
import az.mycompany.shopping_store_product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    final ProductRepository repository;
    final BookClient client;

    @PostConstruct
    public void initDb() {
        List<Book> entities = client.getAll().getBooks();
        for (Book book:entities) {
            ProductEntity product= ProductEntity.builder()
                    .title(book.getTitle())
                    .subtitle(book.getSubtitle())
                    .image(book.getImage())
                    .isbn13(book.getIsbn13())
                    .price(book.getPrice())
                    .url(book.getUrl())
                    .type(ProductType.BOOK)
                    .count(2)
                    .status(true)
                    .build();
           repository.save(product);

        }
    }

    @Override
    public ProductDto add(ProductDto dto) {
        if(repository.existsByIsbn13(dto.getIsbn13())){
           repository.updateCount(dto.getCount(),dto.getIsbn13());
           dto=entityToDto(repository.getByIsbn13(dto.getIsbn13()));

        }else {
             dto= entityToDto(repository.save(dtoToEntity(dto)));
        }
        return  dto;

    }

    @Override
    public void delete(String isbn13) {
        repository.updateStatus(isbn13);

    }

    @Override
    public List<ProductDto> get() {
        return repository
                .findAllByStatus(true)
                .stream().map(this::entityToDto)
                .collect(Collectors.toList());
    }

    private ProductDto entityToDto(ProductEntity entity){
        return ProductDto.builder()
                .count(entity.getCount())
                .image(entity.getImage())
                .isbn13(entity.getIsbn13())
                .price(entity.getPrice())
                .status(entity.getStatus())
                .subtitle(entity.getSubtitle())
                .title(entity.getTitle())
                .type(entity.getType())
                .url(entity.getUrl())
                .build();
    }
    private ProductEntity dtoToEntity(ProductDto dto){
        return ProductEntity.builder()
                .count(dto.getCount())
                .image(dto.getImage())
                .isbn13(dto.getIsbn13())
                .price(dto.getPrice())
                .status(dto.getStatus())
                .subtitle(dto.getSubtitle())
                .title(dto.getTitle())
                .type(dto.getType())
                .url(dto.getUrl())
                .build();
    }
}
