package me.potato.reactivezip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Promotion {
    private Integer id;
    private String  endDate;
    private Double  discount;
    private String  type;
}
