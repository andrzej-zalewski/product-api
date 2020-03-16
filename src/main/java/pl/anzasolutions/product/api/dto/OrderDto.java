package pl.anzasolutions.product.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class OrderDto {

    private Long id;

    @NotEmpty
    private String buyersEmail;

    private LocalDateTime createdAt;
    
    private BigDecimal total;
    
    private List<ProductDto> products;
}
