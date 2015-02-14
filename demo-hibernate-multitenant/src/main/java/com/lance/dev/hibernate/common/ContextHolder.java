package com.lance.dev.hibernate.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author lance
 * @since 2015/2/14 12:37.
 */
public abstract class ContextHolder {

    private static final Logger logger = LogManager.getLogger(ContextHolder.class);
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void setContext(final String context) {
        logger.debug("context set '{}'", context);
        holder.set(context);
    }

    public static String getContext() {
        logger.debug("context get '{}'", holder.get());
        return holder.get();
    }

    public static void clear() {
        logger.debug("context cleared");
        holder.remove();
    }

}