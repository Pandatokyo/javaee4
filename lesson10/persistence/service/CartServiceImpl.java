package lesson10.persistence.service;

import lesson10.persistence.entities.Product;
import lesson10.persistence.repositories.ProductRepository;
import lesson10.persistence.entities.Cart;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartService {

    private final EntityManager em;

    private final ProductRepository productRepository;

    public CartServiceImpl(EntityManager em, ProductRepository productRepository) {
        this.em = em;
        this.productRepository = productRepository;
    }

    @Override
    public Cart getNewCart() {
        return null;
    }

    public List findAllProductsById(Long orderId) {
        return em.createQuery("FROM CartEntry c WHERE c.order_id = :orderId")
                .setParameter("order_id", orderId)
                .getResultList();
    }


    @Override
    public void addProduct(Cart cart, Product product, Integer quantity) {
        cart.addProduct(product, quantity);
    }

    @Override
    public void addProduct(Cart cart, Long prodId, Integer quantity) {
        Product product = (Product) productRepository.findById(prodId).get();
        this.addProduct(cart, product, quantity);
    }

    @Override
    public Long getSum(Cart cart) {
        return cart.getSum();
    }

    public void printCart(Cart cart) {
        long sum = 0L;
        // NOTE: т.к. это мапа, сортировки нет
        for (Map.Entry<Product, Integer> entryMap : cart.getCartMap().entrySet()) {
            Product product = entryMap.getKey();
            long prodSum = product.getPrice() * (Long.valueOf(entryMap.getValue()));
            System.out.printf("Product id = %-2s | name = %-15s | price = %-8s | quantity = %-3s | sum = %-12s \n",
                    product.getId(), product.getName(), product.getPrice(), entryMap.getValue(), prodSum);
            sum += prodSum;
        }
        System.out.println("Общая стоимость продуктов в корзине: " + sum);
    }

    @Override
    public int getProductQuantity(Cart cart, Product product) {
        if (cart.getCartMap().containsKey(product)) {
            return cart.getCartMap().get(product);
        }
        return 0;
    }

    @Override
    public Integer getItemsAmount(Cart cart) {
        Integer amount = 0;
        for (Map.Entry<Product, Integer> entryMap : cart.getCartMap().entrySet()) {
            amount += entryMap.getValue();
        }
        return amount;
    }

    @Override
    public int getProductQuantity(Cart cart, Long prodId) {
        Product product = (Product) productRepository.findById(prodId).get();
        return this.getProductQuantity(cart, product);
    }

    @Override
    public List<Product> getCartListSorted(Cart cart) {
        List<Product> cartList = new ArrayList<>(cart.getCartMap().keySet());
        cartList.sort((p1, p2) -> {
            if (p1.getId() > p2.getId()) {
                return 1;
            } else if (p1.getId() < p2.getId()) {
                return -1;
            }
            return 0;
        });
        return cartList;
    }

}