package az.mycompany.shopping_store_product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShoppingStoreProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingStoreProductApplication.class, args);
    }

}
