package pack;

import org.junit.Test;
import org.slf4j.LoggerFactory;

public class MyTest {

    @Test
    public void test() throws Exception {
        Start.init2("A_LOG_FILE", "A_LOGGER_NAME", "%d{HH:mm:ss.SSS} %-5level %logger - %msg%n");

        while (true) {
            org.slf4j.Logger logger = LoggerFactory.getLogger("A_LOGGER_NAME");
            logger.warn("a warning " + System.currentTimeMillis());
            Thread.sleep(60*1000);
        }

    }
    
}
