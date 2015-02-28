package com.lance.dev.hibernate.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author lance
 * @since 2015/2/14 12:37.
 */
public class ContextHolder {
    private static final Logger logger = LogManager.getLogger(ContextHolder.class);
    private ThreadLocal<String> holder = new ThreadLocal<>();

    private ContextHolder(){}

    public static ContextHolder newInstance() {
        return ContextHolderHelper.instance;
    }

    public void setContext(final String context) {
        logger.debug("context set '{}', Current threadName: {}", context, Thread.currentThread().getName());
        holder.set(context);
    }

    public String getContext() {
        logger.debug("context get '{}', Current threadName: {}", holder.get(), Thread.currentThread().getName());
        return holder.get();
    }

    private static class ContextHolderHelper{
        private static final ContextHolder instance = new ContextHolder();
    }
}