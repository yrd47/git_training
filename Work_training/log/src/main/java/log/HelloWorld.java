package log;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yrd on 2017/5/26.
 *
 */
public class HelloWorld {

    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        BasicConfigurator.configure();
        logger.error("Error Message");
        logger.warn("Warn Message");
        logger.info("Info Message");
        logger.debug("Debug Message");
        logger.trace("Trace Message");
    }
}
