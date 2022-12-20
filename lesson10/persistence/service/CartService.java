package lesson10.persistence.service;

import lesson10.persistence.entities.Product;
import lesson10.persistence.entities.Cart;
import lesson10.persistence.CartEntry;

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