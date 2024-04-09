package br.com.stapassoli.camelmicroServicea.service;

import br.com.stapassoli.camelmicroServicea.model.Product;
import br.com.stapassoli.camelmicroServicea.model.ProductEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;
    private final ProducerTemplate producerTemplate;

    public Product add(Product product) throws JsonProcessingException {
        ProductEvent event = new ProductEvent("ProductCreated", product);
        ObjectMapper obj = new ObjectMapper();

        String jsonEvent = obj.writeValueAsString(event);
        System.out.println(jsonEvent);

        this.producerTemplate.asyncRequestBody("kafka:products?brokers=localhost:29092", jsonEvent);

        return product;
    }

}
