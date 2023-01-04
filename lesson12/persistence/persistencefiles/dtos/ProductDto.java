package lesson12.persistence.persistencefiles.entities.dtos;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String title;
    private Long price;

}
