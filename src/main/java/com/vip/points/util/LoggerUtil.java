package com.vip.points.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.vip.points.util.PropertiesUtil.getLoggerProperty;

public class LoggerUtil {

    public static Logger getLogger(Class<?> clazz) {
        Logger logger = LogManager.getLogger(clazz);

        if(Boolean.parseBoolean(getLoggerProperty("custom.logging.setup.display"))) {
            logger.info("Setting up logger for class " + clazz.getName());
        }
        return logger;
    }

}
