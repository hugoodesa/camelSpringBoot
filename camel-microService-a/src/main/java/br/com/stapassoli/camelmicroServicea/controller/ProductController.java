package br.com.stapassoli.camelmicroServicea.controller;

import br.com.stapassoli.camelmicroServicea.model.Product;
import br.com.stapassoli.camelmicroServicea.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody Product product) throws JsonProcessingException {
        productService.add(product);

        return ResponseEntity.ok().build();
    }

}
