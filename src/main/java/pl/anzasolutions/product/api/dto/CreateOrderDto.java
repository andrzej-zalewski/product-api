package pl.anzasolutions.product.api.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CreateOrderDto {

    @NotEmpty
    private String buyersEmail;

    @NotEmpty
    private List<Long> productIds;
}
