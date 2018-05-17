/**
 * Singleton class to manage the showing message error
 * */
package FS.PRAC.FINAL8.controller;

import org.slf4j.Logger;


/**
 * Singleton control error class
 */
public final class ManErrorControler {

    private ManErrorControler(){}

    public static void showError(Logger logger, Exception e) {
        logger.info("*******************************");
        logger.info("");
        logger.info("Error: " + e.getMessage());
        logger.info("*******************************");
        logger.info("");
    }
}
