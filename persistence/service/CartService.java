package lesson7.persistence.service;

import lesson7.persistence.entities.Cart;
import lesson7.persistence.CartEntry;
import lesson7.persistence.entities.Product;

import java.util.List;

public interface CartService {

    Cart getNewCart();

    void addProduct(Cart cart, Product product, Integer quantity);
    void addProduct(Cart cart, Long prodId, Integer quantity);

    Long getSum(Cart cart);

    Integer getItemsAmount(Cart cart);

    void printCart(Cart cart);

    int getProductQuantity(Cart cart, Product product);
    int getProductQuantity(Cart cart, Long prodId);

    List<Product> getCartListSorted(Cart cart);

    List<CartEntry> findAllProductsById(Long orderId);
}