package com.lance.dev.hibernate.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author lance
 * @since 2015/2/13 16:19.
 */
@Component
@Lazy(false)
public class ApplicationContextUtils implements ApplicationContextAware{
    private final static Logger logger = LogManager.getLogger(ApplicationContextUtils.class);
    private static ApplicationContext sApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        setContext(applicationContext);
    }

    public static void setContext(ApplicationContext aApplicationContext) {
        sApplicationContext = aApplicationContext;
    }

    protected static ApplicationContext getApplicationContext() {
        return sApplicationContext;
    }

    public static Object getBean(String beanName) {
        logger.debug("bean name: {}", beanName);
        if (sApplicationContext != null) {
            return sApplicationContext.getBean(beanName);
        }
        return null;
    }

    public static <T> T getBean(Class<T> aClass) {
        if (sApplicationContext != null) {
            return sApplicationContext.getBean(aClass);
        }
        return null;
    }
}
