package br.com.stapassoli.camelmicroServicea.service;

import br.com.stapassoli.camelmicroServicea.model.ProductEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @KafkaListener(topics = "products", groupId = "products1_group")
    public void processProductEvent(String event) {

        System.out.println("Getting event " + event);
        ProductEvent productEvent = null;

        try {
            productEvent = new ObjectMapper().readValue(event, ProductEvent.class);

            System.out.println(productEvent);

            if (productEvent.getType().equals("ProductCreated")) {
                System.out.println("PRODUCT CREATED");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


}