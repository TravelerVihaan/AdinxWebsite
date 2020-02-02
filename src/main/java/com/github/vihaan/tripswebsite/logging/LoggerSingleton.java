package com.github.vihaan.tripswebsite.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerSingleton{

    private static Logger LOGGER;

    private LoggerSingleton(){}

    public static final Logger getLogger(Class<?> clazz){
        if(LOGGER == null)
            return LoggerFactory.getLogger(clazz.getSimpleName());
        return LOGGER;
    }
}