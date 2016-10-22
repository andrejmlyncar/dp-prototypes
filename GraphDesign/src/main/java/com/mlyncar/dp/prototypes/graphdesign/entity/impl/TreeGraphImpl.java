package com.mlyncar.dp.prototypes.graphdesign.entity.impl;

import com.mlyncar.dp.prototypes.graphdesign.entity.Node;
import com.mlyncar.dp.prototypes.graphdesign.entity.TreeGraph;
import java.util.UUID;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class TreeGraphImpl implements TreeGraph {

    private final Node rootNode;
    private Integer treeDepth = 0;
    private final String treeGraphId;

    public TreeGraphImpl(Node rootNode) {
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
