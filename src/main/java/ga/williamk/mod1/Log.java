package ga.williamk.mod1;


import ga.williamk.mod1.reference.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Log {

    private static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);


    private Log() {

    }

    public static void warn(String msg) {
        LOGGER.warn(msg);
    }

    public static void error(String msg) {
        LOGGER.error(msg);
    }

    public static void info(String msg) {
        LOGGER.info(msg);
    }

    public static void debug(String msg) {
        LOGGER.debug(msg);
    }

    public static void all(String msg) {
        LOGGER.all(msg);
    }

    public static void fatal(String msg) {
        LOGGER.fatal(msg);
    }

    public static void off(String msg) {
        LOGGER.off(msg);
    }

    public static void trace(String msg) {
        LOGGER.trace(msg);
    }

}