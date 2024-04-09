package br.com.stapassoli.camelmicroServicea.controller;

import br.com.stapassoli.camelmicroServicea.model.CurrencyExchangeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyExchange {


    //http://localhost:8080/currency?from=br&to=us
    private double calculateValue(String from) { // can be only to BR TO UDS

        if(from.equalsIgnoreCase("br"))
            return 5.07;

        return  0.20;
    }

    @GetMapping
    public ResponseEntity<CurrencyExchangeDTO> exchange(@RequestParam(value = "from") String from , @RequestParam(value = "to") String to){

        CurrencyExchangeDTO resp = CurrencyExchangeDTO
            .builder()
            .from(from)
            .to(to)
            .value(calculateValue(from))
            .build();

        return ResponseEntity.ok(resp);
    }

}
