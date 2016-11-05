package com.mlyncar.dp.prototypes.synchmodule.exception;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class SynchronizationException extends Exception {

    public SynchronizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SynchronizationException(String message) {
        super(message);
    }
}
