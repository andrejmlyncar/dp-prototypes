package com.mlyncar.dp.prototypes.graphdesign.entity;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public interface Graph {
    
    public String getTreeGraphId();
    
    public Node getRootNode();
    
    public Integer getTreeDepth();
    
    public void incrementTreeDepth();
    
}
