package me.potato.reactivezip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Review {
    private Integer id;
    private Integer rating;
    private String  comment;
    private String  user;
}
