package pl.anzasolutions.product.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pl.anzasolutions.product.api.domain.Product;
import pl.anzasolutions.product.api.dto.ProductDto;
import pl.anzasolutions.product.api.repository.ProductRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void create(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productRepository.save(product);
    }

    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().map(p -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(p, productDto);
            return productDto;
        }).collect(Collectors.toList());
    }

    public void updateOne(ProductDto productDto) {
        Long id = productDto.getId();
        if (id == null) {
            throw new IllegalArgumentException("ID must be given for update");
        }
        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new RuntimeException("Product doesn't exist"));
        BeanUtils.copyProperties(productDto, product);
        productRepository.save(product);
    }
}
