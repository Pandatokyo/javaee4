package lesson7.persistence;


import lesson7.persistence.entities.Order;
import lesson7.persistence.entities.Product;

import javax.persistence.*;

@Entity
@Table(name = "order_products")
public class CartEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn (name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;

    @Column (name = "quantity")
    private Long quantity;

    @Column (name = "whole_price")
    private Long wholePrice;

    @Override
    public String toString() {
        return String.format("\nCartEntry {id = %s, order_id = %s, product_id = %s, quantity = %s, whole_price = %s}",
                id, order.getId(), product.getId(), quantity, wholePrice);
    }
}
