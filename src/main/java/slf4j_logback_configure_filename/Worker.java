package slf4j_logback_configure_filename;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Worker {

    private final Logger log = LoggerFactory.getLogger(Start.class);
    

    public Worker() {
        //System.setProperty("log.name", "mkyong");
        //log.info("hello");
    }

    void doSomething() {
        System.setProperty("log.name", "mkyong");
        //log.info("hello2");
    }
    

}
