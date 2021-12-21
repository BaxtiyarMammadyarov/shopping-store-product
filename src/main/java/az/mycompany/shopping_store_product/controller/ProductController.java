package az.mycompany.shopping_store_product.controller;

import az.mycompany.shopping_store_product.dto.ProductDto;
import az.mycompany.shopping_store_product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.RectangularShape;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDto>> get() {
        return ResponseEntity.ok(service.get());
    }

    @PostMapping
    public ResponseEntity<ProductDto> add(ProductDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }

    @DeleteMapping
    public void delete(String isbn13) {
        service.delete(isbn13);
    }


}
