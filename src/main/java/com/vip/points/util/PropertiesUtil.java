package com.vip.points.util;

import org.apache.logging.log4j.Logger;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class PropertiesUtil {

    private static final String LOGGER_PROPERTIES = "log4j2";
    private static final String SYSTEM_PROPERTIES = "system";
    private static final String MESSAGE_PROPERTIES = "message";
    private static final String GOOGLE_PROPERTIES = "google";

    private static Logger logger = LoggerUtil.getLogger(PropertiesUtil.class);

    private PropertiesUtil() {}

    public static String getProperty(String resourceName, String key) {
        try {
            return getResourceBundle(resourceName).getString(key);
        } catch (MissingResourceException ex) {
            logger.error("Unable to find property " + key);
            return null;
        }
    }

    public static String getMessage(String key) {
        return getProperty(MESSAGE_PROPERTIES, key);
    }

    public static String getSystemProperty(String key) {
        return getProperty(SYSTEM_PROPERTIES, key);
    }

    public static String getGoogleProperty(String key) {
        return getProperty(GOOGLE_PROPERTIES, key);
    }

    public static String getLoggerProperty(String key) {
        return getProperty(LOGGER_PROPERTIES, key);
    }

    private static ResourceBundle getResourceBundle(String name) {
        return ResourceBundle.getBundle(name);
    }

}
