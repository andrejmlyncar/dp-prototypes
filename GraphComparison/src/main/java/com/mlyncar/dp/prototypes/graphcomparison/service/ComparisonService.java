/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlyncar.dp.prototypes.graphcomparison.service;

import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;
import com.mlyncar.dp.prototypes.graphdesign.entity.Node;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public interface ComparisonService {

    public void findSubTree(Graph referenceTree, Graph subTree);

    public boolean isSubTree(Node rootReferenceNode, Node rootSubTreeNode);
}
