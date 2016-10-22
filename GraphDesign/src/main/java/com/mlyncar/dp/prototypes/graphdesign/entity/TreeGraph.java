package com.mlyncar.dp.prototypes.graphdesign.entity;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public interface TreeGraph {
    
    public Node getRootNode();
    
    public Integer getTreeDepth();
    
    public void incrementTreeDepth();
    
}
