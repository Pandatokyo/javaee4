package lesson10.persistence.dtos;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String title;
    private Long price;

}
