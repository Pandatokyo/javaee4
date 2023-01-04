package lesson12.persistence.persistencefiles.repositories;

import lesson10.persistence.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findProductsByPriceBetweenAndTitleLike(Long minPrice, Long maxPrice, String partTitle, Pageable varPageSort);

    Optional<Product> findById(Long id);
}