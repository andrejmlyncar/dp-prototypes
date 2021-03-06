package com.mlyncar.dp.prototypes.graphcomparison.change.impl;

import com.mlyncar.dp.prototypes.graphcomparison.change.Change;
import com.mlyncar.dp.prototypes.graphcomparison.change.ChangeLog;
import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;
import java.sql.Timestamp;
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
    private final String referenceInteractionId;
    private final String subInteractionId;
    private final Timestamp changeLogTimestamp;

    public ChangeLogImpl(Graph subGraph, Graph referenceGraph) {
        this.referenceGraph = referenceGraph;
        this.subGraph = subGraph;
        this.referenceInteractionId = referenceGraph.getTreeGraphId();
        this.subInteractionId = subGraph.getTreeGraphId();
        this.changeLogTimestamp = new Timestamp(System.currentTimeMillis());
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

    @Override
    public String getReferenceInteractionId() {
        return this.referenceInteractionId;
    }

    @Override
    public String getSubInteractionId() {
        return this.subInteractionId;
    }

    @Override
    public Timestamp getChangeLogTimestamp() {
        return this.changeLogTimestamp;
    }
}
