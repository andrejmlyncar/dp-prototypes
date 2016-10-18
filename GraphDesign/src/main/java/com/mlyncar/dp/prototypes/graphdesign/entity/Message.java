package com.mlyncar.dp.prototypes.graphdesign.entity;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public interface Message {
    
    public String getName();
    
    public void setName(String name);
    
    public MessageType getMessageType();
    
    public void setMessageType(MessageType messageType);
    
}
