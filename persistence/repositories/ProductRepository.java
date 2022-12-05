package lesson7.persistence.repositories;

import lesson7.persistence.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByPriceLessThan(Long maxPrice);

    List<Product> findProductByPriceGreaterThan(Long minPrice);

    List<Product> findProductByName(String name);

    Optional<Object> findById(Long prodId);

    void deleteById(Long id);

    List<Product> findAll();

    void saveOrUpdate(Product product);

    Product save(Product product);

    Page<Product> findAllObject(PageRequest pageRequest);
}
