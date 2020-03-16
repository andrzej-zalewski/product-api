package pl.anzasolutions.product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.anzasolutions.product.api.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
