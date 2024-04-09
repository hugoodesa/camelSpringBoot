package br.com.stapassoli.camelmicroServicea.utilBeans;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class GetCurrentTimeBean {

    public String getCurrentTimeOne () {
        return "One:" + LocalDateTime.now().toString();
    }
    public String getCurrentTimeTwo () {
        return "Two:" + LocalDateTime.now().toString();
    }

}
