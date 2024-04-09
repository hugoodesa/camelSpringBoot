package br.com.stapassoli.camelmicroServicea.routes.file;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyFileRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:files/input")
        //.log("${body}")
        .to("file:files/output");
    }

}
