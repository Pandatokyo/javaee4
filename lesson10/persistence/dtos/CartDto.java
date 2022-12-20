package lesson10.persistence.dtos;

import lombok.Data;
import lesson10.persistence.entities.Product;

import java.util.HashMap;
import java.util.Map;

@Data
public class CartDto {

    private Map<Product, Integer> cartMap = new HashMap<>();
    private Long totalSum;

}