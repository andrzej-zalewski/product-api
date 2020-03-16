package pl.anzasolutions.product.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.anzasolutions.product.api.dto.CreateOrderDto;
import pl.anzasolutions.product.api.dto.OrderDto;
import pl.anzasolutions.product.api.dto.TimeIntervalDto;
import pl.anzasolutions.product.api.service.OrderService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void create(@RequestBody @Valid CreateOrderDto dto) {
        orderService.create(dto);
    }

    @GetMapping
    public List<OrderDto> getAllWithin(TimeIntervalDto timeIntervalDto) {
        return orderService.getAllWithin(timeIntervalDto);
    }
}
