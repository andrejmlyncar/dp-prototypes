package com.mlyncar.dp.prototypes.graphcomparison.service.impl;

import com.mlyncar.dp.prototypes.graphcomparison.change.Change;
import com.mlyncar.dp.prototypes.graphcomparison.change.ChangeLog;
import com.mlyncar.dp.prototypes.graphcomparison.change.impl.ChangeLogImpl;
import com.mlyncar.dp.prototypes.graphcomparison.comparator.SubgraphComparator;
import com.mlyncar.dp.prototypes.graphcomparison.service.ComparisonService;
import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;
import com.mlyncar.dp.prototypes.graphdesign.entity.Node;
import com.mlyncar.dp.prototypes.graphdesign.service.GraphCreator;
import com.mlyncar.dp.prototypes.graphdesign.service.impl.GraphCreatorImpl;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class ComparisonServiceImpl implements ComparisonService {

    private final Logger logger = LoggerFactory.getLogger(ComparisonServiceImpl.class);

    @Override
    public ChangeLog getChangesInTwoGraphs(String referenceInteractionId, String subInteractionId) {
        
        GraphCreator creator = new GraphCreatorImpl();
        //random uuid classes
        Graph subGraph = creator.createGraphFromId(UUID.randomUUID().toString());  
        Graph referenceGraph = creator.createGraphFromId(UUID.randomUUID().toString());
        
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
