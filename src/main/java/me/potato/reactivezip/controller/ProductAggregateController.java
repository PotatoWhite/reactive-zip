package me.potato.reactivezip.controller;

import lombok.RequiredArgsConstructor;
import me.potato.reactivezip.dto.ProductAggregate;
import me.potato.reactivezip.service.ProductFlow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class ProductAggregateController {
    private final ProductFlow productFlow;

    @GetMapping("product/{id}")
    public Mono<ProductAggregate> getProductAggregate(@PathVariable Integer id) {
        return this.productFlow.getProductAggregate(id);
    }
}
