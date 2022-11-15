package lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();


    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public void Update(Product product) {
        if (product.getId() == null) {
            long identity = (long) '0';
            Long id = identity + 1;
            product.setId(id);
        }
        productMap.put(product.getId(), product);
    }

    public Product searchById(Long id) {
        return productMap.get(id);
    }

    public void deleteById(Long id) {
        productMap.remove(id);
    }
}