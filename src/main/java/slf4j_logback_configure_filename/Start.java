package slf4j_logback_configure_filename;

import java.io.File;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import ch.qos.logback.core.util.FileSize;

<<<<<<< HEAD
/**
 * 
 */
public class Start {

    public static void main(String[] args) throws Exception  {

        init2("A_LOG_FILE", "A_LOGGER_NAME", "%d{HH:mm:ss.SSS} %-5level %logger - %msg%n");

        while (true) {
            org.slf4j.Logger logger = LoggerFactory.getLogger("A_LOGGER_NAME");
            logger.warn("a warning " + System.currentTimeMillis());
            Thread.sleep(1000);
        }
    }

    public static void init2(String logfilename,String loggername,String pattern) throws Exception {
        LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();

        logfilename = new File(logfilename).getCanonicalPath();

        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(context);
        encoder.setPattern(pattern);
        encoder.start();

        RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<>();
        rollingFileAppender.setContext(context);
        rollingFileAppender.setName(loggername);
        rollingFileAppender.setEncoder(encoder);
        rollingFileAppender.setAppend(true);
        rollingFileAppender.setFile(logfilename+".log");

        TimeBasedRollingPolicy<ILoggingEvent> rollingPolicy = new TimeBasedRollingPolicy<>();
        rollingPolicy.setContext(context);
        rollingPolicy.setParent(rollingFileAppender);
        rollingPolicy.setFileNamePattern(logfilename+".%d{yyyy-MM-dd_HH-mm}.log");
        rollingPolicy.setMaxHistory(10);
        rollingPolicy.setTotalSizeCap(FileSize.valueOf("10KB"));
=======
public class Start2 {

    public static void main(String[] args) throws Exception  {

        init2("A_LOG_FILE", "A_LOGGER_NAME", "%d{HH:mm:ss.SSS} %-5level %logger - %msg%n");

        while (true) {
            org.slf4j.Logger logger = LoggerFactory.getLogger("A_LOGGER_NAME");
            logger.warn("a warning " + System.currentTimeMillis());
            Thread.sleep(1000);
        }
    }

    public static void init2(String logfilename,String loggername,String pattern) throws Exception {
        LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();

        logfilename = new File(logfilename).getCanonicalPath();

        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(context);
        encoder.setPattern(pattern);
        encoder.start();

        RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<>();
        rollingFileAppender.setContext(context);
        rollingFileAppender.setName(loggername);
        rollingFileAppender.setEncoder(encoder);
        rollingFileAppender.setAppend(true);
        rollingFileAppender.setFile(logfilename+".log");

        TimeBasedRollingPolicy<ILoggingEvent> rollingPolicy = new TimeBasedRollingPolicy<>();
        rollingPolicy.setContext(context);
        rollingPolicy.setParent(rollingFileAppender);
        rollingPolicy.setFileNamePattern(logfilename+".%d{yyyy-MM-dd_HH-mm}.log");
        rollingPolicy.setMaxHistory(10);
        rollingPolicy.setTotalSizeCap(FileSize.valueOf("1KB"));
>>>>>>> branch 'master' of https://github.com/riskop/slf4j_logback_rollingfileappender_programatically
        rollingPolicy.setCleanHistoryOnStart(false);
        rollingPolicy.start();

        rollingFileAppender.setRollingPolicy(rollingPolicy);     
        rollingFileAppender.start();

        Logger logger = (Logger)LoggerFactory.getLogger(loggername);
        logger.setAdditive(false);
        logger.setLevel(Level.INFO);
        logger.detachAndStopAllAppenders();
        logger.addAppender(rollingFileAppender);
    }

}
