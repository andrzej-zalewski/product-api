package pl.anzasolutions.product.api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.anzasolutions.product.api.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCreatedAtBetweenOrderByCreatedAtDesc(LocalDateTime from, LocalDateTime to);
}
