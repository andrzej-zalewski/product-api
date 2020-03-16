package pl.anzasolutions.product.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    private BigDecimal price;
}
