package lesson7.persistence;

import lesson7.persistence.entities.Product;
import lesson7.persistence.repositories.ProductRepository;
import lesson7.persistence.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.NoResultException;


@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final ProductRepository productRepository;

    public SpringDataApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) {

        //получение товара по id
        System.out.println("\nПродукт: " + productRepository.findById(1L).orElseThrow(() ->
                new NoResultException("Товар с указанным id не существует!")));

        System.out.println("\nСписок всех продуктов: ");
        productRepository.findAll().forEach(System.out::println);

        System.out.println("\nСписок продуктов по 10 штук");
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Product> products = productRepository.findAllObject(pageRequest);


        Product product = null;

        //обновление товара по id
        System.out.println("Обновление товара по id ( 5 )");
        product = (Product) productRepository.findById(5L).orElseThrow(() ->
                new NoResultException("Товар с указанным id не существует!"));
        product.setName("New name");
        product.setPrice(20L);
        productRepository.save(product);
        System.out.println("\nПродукт: " + productRepository.findById(5L).orElseThrow(() ->
                new NoResultException("Товар с указанным id не существует!")));


        //новый товар с id (25)
        product = new Product(25L, "new name", 111L);
        productRepository.save(product);
        product = productRepository.findProductByName("new name").get(0);

        //удаление ранее созданного товара по id
        Long tempId = product.getId();
        System.out.println("id = " +  tempId);
        productRepository.deleteById(tempId);


        //фильтрация по максимальной цене
        System.out.println("\nПродукты с ценой до 30: ");
        productRepository.findProductByPriceLessThan(30L).forEach(System.out::println);

        System.out.println("\n-------------");

        //фильтрация по минимальной цене
        System.out.println("\nПродукты с ценой более 150: ");
        productRepository.findProductByPriceGreaterThan(150L).forEach(System.out::println);


    }
}
