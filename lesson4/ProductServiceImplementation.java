package lesson4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product searchById(Long id) {
        return productRepository.searchById(id);
    }

    @Override
    public void Update(Product product) {
        productRepository.Update(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}