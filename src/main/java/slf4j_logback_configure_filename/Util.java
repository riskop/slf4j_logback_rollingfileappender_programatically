package slf4j_logback_configure_filename;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {

    private static final Logger LOG = LoggerFactory.getLogger(Util.class);
    
    public static void doSomething() {
        LOG.info("static bol");
    }
    
}
