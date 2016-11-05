package com.mlyncar.dp.prototypes.synchmodule.exception;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class ConfigurationException extends Exception {

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(String message) {
        super(message);
    }
}
