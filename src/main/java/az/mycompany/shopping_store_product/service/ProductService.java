package az.mycompany.shopping_store_product.service;

import az.mycompany.shopping_store_product.dto.ProductDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductDto add(ProductDto dto);
    void delete(String isbn13);
    List<ProductDto>get();

}
