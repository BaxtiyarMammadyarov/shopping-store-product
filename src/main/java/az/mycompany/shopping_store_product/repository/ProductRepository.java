package az.mycompany.shopping_store_product.repository;

import az.mycompany.shopping_store_product.dto.ProductDto;
import az.mycompany.shopping_store_product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Query(value = "update product p set status=false where p.isbn13=:isbn13",nativeQuery = true)
    void updateStatus(@Param("isbn13") String isbn13);

    List<ProductEntity> findAllByStatus(boolean b);

    boolean existsByIsbn13(String isbn13);
    @Query(value = "update product p set count=:count where p.isbn13=:isbn13",nativeQuery = true)
    void updateCount(@Param("count") int count ,@Param("isbn13") String isbn13);

    ProductEntity getByIsbn13(String isbn13);
}
