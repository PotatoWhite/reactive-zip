package me.potato.reactivezip.client;

import lombok.extern.slf4j.Slf4j;
import me.potato.reactivezip.dto.Review;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class ReviewClient {
    private final WebClient client;

    public ReviewClient(@Value("${review.service.url}") String baseUrl) {
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    // get a product by id
    // return Mono<Product>
    public Mono<List<Review>> getReviews(Integer id) {
        return this.client.get()
                .uri("{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(), response -> Mono.error(new RuntimeException("Error")))
                .bodyToFlux(Review.class)
                .doOnNext(product -> log.info("Review: {}", product))
                .collectList();
    }
}
