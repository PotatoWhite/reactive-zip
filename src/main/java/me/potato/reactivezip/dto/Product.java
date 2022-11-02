package me.potato.reactivezip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Product {
    private Integer id;
    private Integer price;
    private String  description;
    private String  category;
}
