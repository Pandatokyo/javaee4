package lesson12.persistence.service;

import lesson10.persistence.entities.Product;
import lesson12.persistence.persistencefiles.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Page<Product> findAllFilteredPaged(Long minPrice, Long maxPrice, String partTitle, Integer pageIndex, Integer productsPerPage) {
        Pageable pageRequest = PageRequest.of(pageIndex - 1, productsPerPage);
        return productRepository.findProductsByPriceBetweenAndTitleLike(minPrice, maxPrice, "%"+partTitle+"%", pageRequest);
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        return productRepository.deleteById(id);
    }

}