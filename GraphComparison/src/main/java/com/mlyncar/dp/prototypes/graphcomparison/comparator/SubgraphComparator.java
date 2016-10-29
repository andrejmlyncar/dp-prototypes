/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlyncar.dp.prototypes.graphcomparison.comparator;

import com.mlyncar.dp.prototypes.graphdesign.entity.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class SubgraphComparator {

    private final Logger logger = LoggerFactory.getLogger(SubgraphComparator.class);
   
    public boolean isSubTree(Node rootReferenceNode, Node rootSubTreeNode) {

        if (rootSubTreeNode == null) {
            return true;
        }
        if (rootReferenceNode == null) {
            return false;
        }
        logger.debug("Starting to compare nodes {} {} ", rootReferenceNode.getName(), rootSubTreeNode.getName());

        if (rootReferenceNode.isNodeEqual(rootSubTreeNode)) {
            logger.debug("Nodes {} {} and {} {} are equal", rootReferenceNode.getId(), rootReferenceNode.getName(), rootSubTreeNode.getId(), rootSubTreeNode.getName());
            if (rootReferenceNode.isLeaf()) {
                logger.debug("Node {} is leaf", rootReferenceNode.getName());
                return true;
            } else {
                logger.debug("Starting comparing children of {}", rootReferenceNode.getName());
                int childIndex = 0;
                boolean comparisonResult = true;
                for (Node referenceGraphChild : rootReferenceNode.childNodes()) {
                    comparisonResult = comparisonResult && isSubTree(referenceGraphChild, rootSubTreeNode.childNodes().get(childIndex));
                    childIndex++;
                }
                logger.debug("Comparison Result of childrens of {} is {}", rootReferenceNode.getName(), comparisonResult);
                return comparisonResult;
            }
        }
        return rootReferenceNode.childNodes().stream().anyMatch((referenceGraphChild) -> (isSubTree(referenceGraphChild, rootSubTreeNode)));
    }
}
