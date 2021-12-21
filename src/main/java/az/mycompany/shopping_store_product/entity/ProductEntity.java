package az.mycompany.shopping_store_product.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "type", nullable = false)
    ProductType type;
    @Column(name = "title", nullable = false)
    String title;
    @Column(name = "subtitle", nullable = false)
    String subtitle;
    @Column(name = "isbn13", nullable = false, unique = true)
    String isbn13;
    @Column(name = "price", nullable = false)
    String price;
    @Column(name = "image", nullable = false)
    String image;
    @Column(name = "url", nullable = false)
    String url;
    @Column(name = "count", nullable = false)
    int count;
    @Column(name = "status", nullable = false)
    Boolean status;

}
