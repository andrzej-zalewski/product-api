package pl.anzasolutions.product.api.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pl.anzasolutions.product.api.domain.Order;
import pl.anzasolutions.product.api.domain.OrderProduct;
import pl.anzasolutions.product.api.dto.CreateOrderDto;
import pl.anzasolutions.product.api.dto.OrderDto;
import pl.anzasolutions.product.api.dto.ProductDto;
import pl.anzasolutions.product.api.dto.TimeIntervalDto;
import pl.anzasolutions.product.api.repository.OrderRepository;
import pl.anzasolutions.product.api.repository.ProductRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public void create(CreateOrderDto dto) {
        Order newOrder = new Order();
        BeanUtils.copyProperties(dto, newOrder);
        Order order = orderRepository.save(newOrder);
        
        List<Long> productIds = dto.getProductIds();
        List<OrderProduct> orderProducts = productRepository.findAllById(productIds).stream()
                .map(p -> OrderProduct.builder()
                        .name(p.getName())
                        .order(order)
                        .price(p.getPrice())
                        .productId(p.getId())
                        .build())
                .collect(Collectors.toList());
        
        BigDecimal total = orderProducts.stream()
                .map(p -> p.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        order.setProducts(orderProducts);
        order.setCreatedAt(LocalDateTime.now());
        order.setBuyersEmail(dto.getBuyersEmail());
        order.setTotal(total);

        orderRepository.save(order);
    }

    public List<OrderDto> getAllWithin(TimeIntervalDto timeIntervalDto) {
        List<Order> orders = orderRepository.findByCreatedAtBetweenOrderByCreatedAtDesc(timeIntervalDto.getFrom(), timeIntervalDto.getTo());
        return orders.stream().map(o -> {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(o, orderDto);

            List<ProductDto> products = o.getProducts().stream().map(p -> {
                ProductDto productDto = new ProductDto();
                BeanUtils.copyProperties(p, productDto);
                return productDto;
            }).collect(Collectors.toList());

            orderDto.setProducts(products);
            
            return orderDto;
        }).collect(Collectors.toList());
    }
}
