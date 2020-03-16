package pl.anzasolutions.product.api.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_products")
public class OrderProduct {

    @Id
    @SequenceGenerator(name = "order_product_id_generator", sequenceName = "order_product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_product_id_generator")
    private Long id;

    private Long productId;

    private String name;

    private BigDecimal price;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}