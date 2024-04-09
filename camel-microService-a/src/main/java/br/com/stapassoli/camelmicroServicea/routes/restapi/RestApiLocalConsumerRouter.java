package br.com.stapassoli.camelmicroServicea.routes.restapi;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

//@Component
public class RestApiLocalConsumerRouter extends RouteBuilder {


    //http://localhost:8080/currency?from=br&to=us
    @Override
    public void configure() throws Exception {

        restConfiguration()
            .port(8080)
            .host("localhost")
            .component("servlet")
            .bindingMode(RestBindingMode.auto);

        from("timer:apiTimer?period=60000") // Trigger the route every 60 seconds
            .to("rest:get:/currency?from=br&to=us")
            .log("Response from GitHub API: ${body}");

    }

}
