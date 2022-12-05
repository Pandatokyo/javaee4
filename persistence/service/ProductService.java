package lesson7.persistence.service;

import lesson7.persistence.entities.Product;

import java.util.List;

public interface ProductService {

    List<Object> getProductList();

    void saveOrUpdate(Product product);

    Product getProductById(Long id);

    void deleteById(Long id);

}
