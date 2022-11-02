package me.potato.reactivezip.service;

import lombok.RequiredArgsConstructor;
import me.potato.reactivezip.client.ProductClient;
import me.potato.reactivezip.client.PromotionClient;
import me.potato.reactivezip.client.ReviewClient;
import me.potato.reactivezip.dto.ProductAggregate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProductFlow {

    private final ProductClient   productClient;
    private final ReviewClient    reviewClient;
    private final PromotionClient promotionClient;


    public Mono<ProductAggregate> getProductAggregate(Integer id) {
        return Mono.zip(
                        productClient.getProduct(id),
                        promotionClient.getPromotion(id),
                        reviewClient.getReviews(id)
                )
                .map(tuple -> {
                    var product   = tuple.getT1();
                    var promotion = tuple.getT2();
                    var review    = tuple.getT3();

                    return ProductAggregate.of(product.getId(), product.getCategory(), product.getPrice(), promotion.getDiscount(), review);
                });
    }
}
