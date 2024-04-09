package br.com.stapassoli.camelmicroServicea.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CurrencyExchangeDTO {

    private String from;
    private String to;
    private double value;

}
