package lesson10.persistence.entities;

import lesson10.persistence.CartEntry;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "FROM Product p"),
        @NamedQuery(name = "Product.findAllSortedByName", query = "FROM Product p ORDER BY p.name ASC"),
        @NamedQuery(name = "Product.findById", query = "FROM Product p WHERE p.id = :id"),
        @NamedQuery(name = "Product.deleteById", query = "DELETE FROM Product p WHERE p.id = :id")
})

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;

    @OneToMany(mappedBy = "product")
    private List<CartEntry> cartEntries;

    public Product() { }

    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product id = %s, name = %s, price = %s", id, name, price);
    }

    public Long getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public Object getName() { return name; }

    public void setPrice(Long valueOf) {
    }

    public void setName(String new_product_name) {
    }
}
