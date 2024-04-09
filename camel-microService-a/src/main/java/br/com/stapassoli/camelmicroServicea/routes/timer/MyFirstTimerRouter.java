package br.com.stapassoli.camelmicroServicea.routes.timer;

import br.com.stapassoli.camelmicroServicea.utilBeans.GetCurrentTimeBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
@RequiredArgsConstructor
public class MyFirstTimerRouter extends RouteBuilder {

    private final GetCurrentTimeBean getCurrentTimeBean;

    @Override
    public void configure() throws Exception {
        //Exchange[ExchangePattern: InOnly, BodyType: null, Body: [Body is null]]
        from("timer:first-timer")
            //.log("${body}")
            .transform().constant("My constant message")
            //.log("${body}")
            .bean(getCurrentTimeBean, "getCurrentTimeOne");
            //.log("${body}")
            //.transform().constant("Sending to simpleLoggin")
            //.process(new SimpleLogginProcessor())
            //.to("log:first-timer");
    }

}
