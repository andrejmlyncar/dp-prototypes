package com.mlyncar.dp.prototypes.graphcomparison.change.impl;

import com.mlyncar.dp.prototypes.graphcomparison.change.Change;
import com.mlyncar.dp.prototypes.graphcomparison.change.ChangeLog;
import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class ChangeLogImpl implements ChangeLog {

    private final Graph referenceGraph;
    private final Graph subGraph;
    private final List<Change> changes = new ArrayList<>();

    public ChangeLogImpl(Graph subGraph, Graph referenceGraph) {
        this.referenceGraph = referenceGraph;
        this.subGraph = subGraph;
    }

    @Override
    public Graph getReferenceGraph() {
        return this.referenceGraph;
    }

    @Override
    public Graph getSubGraph() {
        return this.subGraph;
    }

    @Override
    public void addChange(Change change) {
        this.changes.add(change);
    }

    @Override
    public List<Change> changes() {
        return this.changes;
    }
}
