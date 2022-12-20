package lesson10.persistence.entities;

import lesson10.persistence.CartEntry;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    public Order(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private final User user;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @OneToMany(mappedBy = "order")
    private List<CartEntry> cartEntries;

    @Override
    public String toString() {
        return String.format("Order {id = %s, user_id = %s}", id, user.getId());
    }

    public Object getId() {
        return id;
    }
}