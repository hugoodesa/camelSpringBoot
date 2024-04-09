package br.com.stapassoli.camelmicroServicea.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEvent {

    private String type;
    private Product product;
}
