package br.com.stapassoli.camelmicroServicea.routes.restapi;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RestApiConsumerRouter extends RouteBuilder {

    //choose one of the two methods

    //http://localhost:8080/currency?from=br&to=us
    //MODE 1
    @Override
    public void configure() throws Exception {

        from("timer:githubTimer?period=60000") // Trigger the route every 60 seconds
            .to("https://api.github.com/users/hugoodesa/repos")
            .log("Response from GitHub API: ${body}");

    }

    @Override
    //MODE 2
    public void configure() throws Exception {

        restConfiguration()
            .host("https://api.github.com/users")
            .component("servlet")
            .bindingMode(RestBindingMode.auto);;

        from("timer:githubTimer?period=60000")
            .removeHeaders("CamelHttp*")
            .to("rest:get:/hugoodesa/repos")
            .log("Response from GitHub API: ${body}");
    }
    
}
