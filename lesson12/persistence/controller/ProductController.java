package lesson12.persistence.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import lesson12.persistence.persistencefiles.entities.Product;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    @GetMapping({"", "/"})
    public String getProductsPage() {
        return "Products List Page / список товаров";
    }

    @GetMapping("/edit")
    public String editProductList() {
        return "Список товаров";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long productId) {
        return "Редактирование товара";
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createProduct(@RequestBody Product product) {
        return "Сохранить товар";
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateProduct(@RequestBody Product product) {
        return "Изменить данные товара";
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        return "Удалить товар по id";
    }

}