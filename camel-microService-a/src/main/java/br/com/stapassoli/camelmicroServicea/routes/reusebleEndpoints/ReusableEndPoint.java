package br.com.stapassoli.camelmicroServicea.routes.reusebleEndpoints;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ReusableEndPoint extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:githubTimer?period=10000")
            .to("direct:myProducer");

        from("direct:myProducer")
            .transform().constant("My message to other component")
            .to("direct:myConsumer");

        from("direct:myConsumer")
            .log("${body}")
            .process(new MyProcessor());

    }
}

class MyProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("==== MyProcessor ====");
        System.out.println(exchange.getMessage());
        System.out.println("=====================");
    }
}