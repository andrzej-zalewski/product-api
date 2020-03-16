package pl.anzasolutions.product.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.anzasolutions.product.api.dto.ProductDto;
import pl.anzasolutions.product.api.service.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void create(@RequestBody @Valid ProductDto dto) {
        productService.create(dto);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @PutMapping
    public void updateOne(@RequestBody @Valid ProductDto dto) {
        productService.updateOne(dto);
    }
}
