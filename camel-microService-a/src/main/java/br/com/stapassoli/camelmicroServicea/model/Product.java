package br.com.stapassoli.camelmicroServicea.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;

}
