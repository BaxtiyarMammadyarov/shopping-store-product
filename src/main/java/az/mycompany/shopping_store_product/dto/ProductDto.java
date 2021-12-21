package az.mycompany.shopping_store_product.dto;

import az.mycompany.shopping_store_product.entity.ProductType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    ProductType type;
    String title;
    String subtitle;
    String isbn13;
    String price;
    String image;
    String url;
    Boolean status;
    int count;
}
