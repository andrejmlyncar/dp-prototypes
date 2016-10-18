package com.mlyncar.dp.prototypes.graphdesign.entity.impl;

import com.mlyncar.dp.prototypes.graphdesign.entity.Message;
import com.mlyncar.dp.prototypes.graphdesign.entity.MessageType;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class MessageImpl implements Message {

    private String name;
    private MessageType messageType;
    
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
    
}
