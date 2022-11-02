package me.potato.reactivezip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ProductAggregate implements Serializable {
    private Integer      id;
    private String       category;
    private Integer      price;
    private Double       discount;
    private List<Review> reviews;
}
