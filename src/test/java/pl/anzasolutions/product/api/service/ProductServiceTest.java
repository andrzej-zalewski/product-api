package pl.anzasolutions.product.api.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.anzasolutions.product.api.domain.Product;
import pl.anzasolutions.product.api.dto.ProductDto;
import pl.anzasolutions.product.api.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @DisplayName("Simple product is created")
    @Test
    void shouldCreateAProduct() throws Exception {

        // given
        ProductDto dto = new ProductDto();

        // when
        productService.create(dto);

        // then
        verify(productRepository).save(ArgumentMatchers.any(Product.class));
    }
}
