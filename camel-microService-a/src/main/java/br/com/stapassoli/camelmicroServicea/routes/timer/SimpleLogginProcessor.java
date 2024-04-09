package br.com.stapassoli.camelmicroServicea.routes.timer;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
public class SimpleLogginProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        //log.info("Exchange : {} ", exchange.getMessage().getBody());
    }

}
