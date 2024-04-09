package br.com.stapassoli.camelmicroServicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//CONSUMER
@Component
public class KafkaConsumer extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:myKafkaTopicCamel")
            .transform().constant("My message for kafka");
            //.to("log:received-message");
    }

}
