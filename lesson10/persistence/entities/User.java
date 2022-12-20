package lesson10.persistence.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public User(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private final String name;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    @Override
    public String toString() {
        return String.format("User id = %s, name = %s", id, name);
    }

    public Object getId() {
        return id;
    }
}