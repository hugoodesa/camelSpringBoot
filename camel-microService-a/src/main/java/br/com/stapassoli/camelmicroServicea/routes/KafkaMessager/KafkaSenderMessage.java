package br.com.stapassoli.camelmicroServicea.routes.KafkaMessager;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//PRODUCER (the topic will be automatic created)
//@Component
public class KafkaSenderMessage extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:active-kafka-timer?period=10000")
        .transform().constant("My message for kafka")
        .to("kafka:myKafkaTopicCamel");
    }

}
