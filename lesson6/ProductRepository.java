package lesson6;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRepository {

    private static final ProductRepository INSTANCE = new ProductRepository();
    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    public static ProductRepository getInstance() {
        return INSTANCE;
    }

    {

        productMap.put(1L, new Product(1L, "milk", 55.1));
        productMap.put(2L, new Product(2L, "sugar", 130.0));
        productMap.put(3L, new Product(3L, "coffee", 513.1));
        productMap.put(4L, new Product(4L, "tea", 100.0));
        productMap.put(5L, new Product(5L, "cup", 303.15));
    }


    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public void Update(Product product) {
        if (product.getId() == null) {
            Long id = Collections.max(productMap.keySet()) + 1;
            product.setId(id);
        }
        productMap.put(product.getId(), product);
    }

    public Product searchById(Long id) { return productMap.get(id); }

    public void deleteById(Long id) {
        productMap.remove(id);
    }
}