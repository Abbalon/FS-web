package com.spring.data.ejercicios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Singleton control error class
 */
public class ManErrorControler {

    private static ManErrorControler errorControler;
    private static Logger logger;

    private Class t;

    private ManErrorControler(Class t) {
        this.t = t;
    }

    public static ManErrorControler getErrorControler(Class t) {
        if (errorControler == null) {
            errorControler = new ManErrorControler(t);
        } else {
            logger = LoggerFactory.getLogger(t);
        }
        return errorControler;
    }

    public void showError(Exception e) {
        logger.info("*******************************");
        logger.info("");
        logger.info("Error: " + e.getMessage());
        logger.info("*******************************");
        logger.info("");
    }
}
