package slf4j_logback_configure_filename;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Start {

    public static void main(String[] args) {
        
        //Set this before the logger start.
        System.setProperty("log.name", "logfile_" + System.currentTimeMillis());
        
        new Worker().doSomething();
        
        Util.doSomething();
    }

}
