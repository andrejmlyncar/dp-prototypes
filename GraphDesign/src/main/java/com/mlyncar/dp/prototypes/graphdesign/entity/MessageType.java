package com.mlyncar.dp.prototypes.graphdesign.entity;

import com.mlyncar.dp.prototypes.graphdesign.exception.MessageTypeException;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public enum MessageType {

    SYNCH("synchronous"),
    ASYNCH("asynchronous"),
    CREATE("create"),
    RETURN("return"),
    DESTROY("destroy"),
    SELF("self");

    private final String code;

    private MessageType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static MessageType fromCode(String code) throws MessageTypeException {
        for (MessageType reason : MessageType.values()) {
            if (reason.getCode().equals(code)) {
                return reason;
            }
        }
        throw new MessageTypeException("Unknown message type " + code);
    }
}
