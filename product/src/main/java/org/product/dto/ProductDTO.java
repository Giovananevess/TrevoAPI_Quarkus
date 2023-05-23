package org.product.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private String name;

    private String description;

    private LocalDate cultura;

    private Boolean area;

    private LocalDate data;

}
