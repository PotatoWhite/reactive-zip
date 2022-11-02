package me.potato.reactivezip.client;

import lombok.extern.slf4j.Slf4j;
import me.potato.reactivezip.dto.Promotion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class PromotionClient {
    private final WebClient client;

    public PromotionClient(@Value("${promotion.service.url}") String baseUrl) {
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    // get a product by id
    // return Mono<Product>
    public Mono<Promotion> getPromotion(Integer id) {
        return this.client.get()
                .uri("{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(), response -> Mono.error(new RuntimeException("Error")))
                .bodyToMono(Promotion.class)
                .doOnNext(product -> log.info("Product: {}", product));
    }
}
