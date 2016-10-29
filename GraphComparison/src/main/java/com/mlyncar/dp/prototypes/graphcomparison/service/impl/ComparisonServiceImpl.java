/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlyncar.dp.prototypes.graphcomparison.service.impl;

import com.mlyncar.dp.prototypes.graphcomparison.change.Change;
import com.mlyncar.dp.prototypes.graphcomparison.change.ChangeLog;
import com.mlyncar.dp.prototypes.graphcomparison.change.impl.ChangeLogImpl;
import com.mlyncar.dp.prototypes.graphcomparison.comparator.SubgraphComparator;
import com.mlyncar.dp.prototypes.graphcomparison.service.ComparisonService;
import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;
import com.mlyncar.dp.prototypes.graphdesign.entity.Node;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class ComparisonServiceImpl implements ComparisonService {

    private final Logger logger = LoggerFactory.getLogger(ComparisonServiceImpl.class);

    @Override
    public ChangeLog getChangesInTwoGraphs(Graph referenceGraph, Graph subGraph) {
        ChangeLog changeLog = new ChangeLogImpl(subGraph, referenceGraph);
        //No changes detected - just return changelog
        if (isGraphSubgraph(referenceGraph, subGraph)) {
            return changeLog;
        }
        //check for changes in graph
        changeLog.changes().addAll(findChangesInGraph(referenceGraph, subGraph));
        return changeLog;
    }

    @Override
    public List<Change> findChangesInGraph(Graph referenceTree, Graph subTree) {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    @Override
    public boolean isGraphSubgraph(Graph referenceTree, Graph subTree) {
        Node rootReferenceNode = referenceTree.getRootNode();
        Node rootSubTreeNode = subTree.getRootNode();
        SubgraphComparator comparator = new SubgraphComparator();
        return comparator.isSubTree(rootReferenceNode, rootSubTreeNode);
    }

}
