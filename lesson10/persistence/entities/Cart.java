package lesson10.persistence.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {

    private final Map<Product, Integer> cartMap = new HashMap<>();

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }

    public void addProduct(Product product, Integer quantity) {
        if (product != null) cartMap.merge(product, quantity, Integer::sum);
        if (cartMap.get(product) < 1) cartMap.remove(product);
    }

    public Long getSum() {
        long sum = 0L;
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            sum += (entry.getKey().getPrice() * (Long.valueOf(entry.getValue())));
        }
        return sum;
    }

}
