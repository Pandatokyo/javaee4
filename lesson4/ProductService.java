package lesson4;


import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    void Update(Product product);

    Product searchById(Long id);

    void deleteById(Long id);

}
