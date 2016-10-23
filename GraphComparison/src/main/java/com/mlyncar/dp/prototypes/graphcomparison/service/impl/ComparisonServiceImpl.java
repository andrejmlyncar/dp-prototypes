/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlyncar.dp.prototypes.graphcomparison.service.impl;

import com.mlyncar.dp.prototypes.graphcomparison.service.ComparisonService;
import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;
import com.mlyncar.dp.prototypes.graphdesign.entity.Node;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class ComparisonServiceImpl implements ComparisonService {

    @Override
    public void findSubTree(Graph referenceTree, Graph subTree) {
        Node rootReferenceNode = referenceTree.getRootNode();
        Node rootSubTreeNode = subTree.getRootNode();

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isSubTree(Node rootReferenceNode, Node rootSubTreeNode) {

        if (rootSubTreeNode == null) {
            return true;
        }
        if (rootReferenceNode == null) {
            return false;
        }

        if (rootReferenceNode.isNodeEqual(rootSubTreeNode)) {
            if (rootReferenceNode.isLeaf()) {
                return true;
            }
            int childIndex = 0;
            for (Node referenceGraphChild : rootReferenceNode.childNodes()) {
                if (!isSubTree(referenceGraphChild, rootSubTreeNode.childNodes().get(childIndex))) {
                    return true;
                }
                childIndex++;
            }
        }
        return rootReferenceNode.childNodes().stream().anyMatch((referenceGraphChild) -> (isSubTree(referenceGraphChild, rootSubTreeNode)));
    }

}
