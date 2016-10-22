package com.mlyncar.dp.prototypes.graphdesign.entity.impl;

import com.mlyncar.dp.prototypes.graphdesign.entity.Message;
import com.mlyncar.dp.prototypes.graphdesign.entity.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class MessageImpl implements Message {

    private String name;
    private MessageType messageType;
    private final Logger logger = LoggerFactory.getLogger(MessageImpl.class);

    public MessageImpl(String name, MessageType messageType) {
        this.name = name;
        this.messageType = messageType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public MessageType getMessageType() {
        return this.messageType;
    }

    @Override
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    @Override
    public boolean isMessageEqual(Message message) {
        this.logger.debug("Checking equality of message {} and {} ", message.getName(), this.getName());
        return message.getMessageType().getCode().equals(this.getMessageType().getCode())
                && message.getName().equals(this.getName());
    }

}
