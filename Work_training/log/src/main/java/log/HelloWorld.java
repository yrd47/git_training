package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yrd on 2017/5/26.
 *
 */
public class HelloWorld {

    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        logger.info("Hello World");
    }
}
