package com.mlyncar.dp.prototypes.graphdesign.entity.impl;

import com.mlyncar.dp.prototypes.graphdesign.entity.Node;
import java.util.UUID;
import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class TreeGraph implements Graph {

    private final Node rootNode;
    private Integer treeDepth = 0;
    private final String treeGraphId;

    public TreeGraph(Node rootNode) {
        this.rootNode = rootNode;
        this.treeGraphId = UUID.randomUUID().toString();
    }

    @Override
    public Node getRootNode() {
        return this.rootNode;
    }

    @Override
    public Integer getTreeDepth() {
        return this.treeDepth;
    }

    @Override
    public void incrementTreeDepth() {
        this.treeDepth++;
    }

    @Override
    public String getTreeGraphId() {
       return this.treeGraphId;
    }

}
