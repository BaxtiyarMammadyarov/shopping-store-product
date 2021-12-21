package az.mycompany.shopping_store_product.client;

import az.mycompany.shopping_store_product.dto.Books;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "book", url = "https://api.itbook.store/1.0")
public interface BookClient {

    @GetMapping("/new")
    Books getAll();
}
