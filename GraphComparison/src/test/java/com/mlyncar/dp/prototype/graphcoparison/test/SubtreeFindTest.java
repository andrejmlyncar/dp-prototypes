/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlyncar.dp.prototype.graphcoparison.test;

import com.mlyncar.dp.prototypes.graphcomparison.service.ComparisonService;
import com.mlyncar.dp.prototypes.graphcomparison.service.impl.ComparisonServiceImpl;
import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;
import com.mlyncar.dp.prototypes.graphdesign.entity.Node;
import com.mlyncar.dp.prototypes.graphdesign.entity.impl.NodeImpl;
import com.mlyncar.dp.prototypes.graphdesign.entity.impl.TreeGraph;
import java.util.UUID;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class SubtreeFindTest {

    @Test
    public void subtreeFinderBasicTest() {
        Node node = new NodeImpl(UUID.randomUUID().toString(), null, null, "Student");
        Graph graph = new TreeGraph(node);
        Graph subGraph = new TreeGraph(null);
        ComparisonService comparisonService = new ComparisonServiceImpl();
        assertTrue("Null graph is not subgraph of any graph", comparisonService.isSubTree(graph.getRootNode(), subGraph.getRootNode()));
        subGraph = new TreeGraph(node);
        assertTrue("Null graph is not subgraph of any graph with same node", comparisonService.isSubTree(graph.getRootNode(), subGraph.getRootNode()));
    }
}
