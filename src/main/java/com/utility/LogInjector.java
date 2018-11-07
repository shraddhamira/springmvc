package com.utility;


import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
public class LogInjector implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String name) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                // make the field accessible if defined private
                ReflectionUtils.makeAccessible(field);
                if (field.getAnnotation(Log.class) != null) {
                    Logger log = Logger.getLogger(bean.getClass());
                    field.set(bean, log);
                }
            }
        });
        return bean;
    }
}