package org.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.product.dto.ProductDTO;
import java.time.LocalDate;

@Entity
@Table(name = "db_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private LocalDate cultura;

    private Boolean area;

    private LocalDate data;

    public Product(ProductDTO dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.data = LocalDate.now();
        this.cultura = dto.getCultura();
        this.area = dto.getArea();
    }

    public void update(ProductDTO dto) {
        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getDescription() != null) {
            this.description = dto.getDescription();
        }
    }
}
