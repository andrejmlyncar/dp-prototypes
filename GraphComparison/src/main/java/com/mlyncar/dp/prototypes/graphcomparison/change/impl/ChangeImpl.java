package com.mlyncar.dp.prototypes.graphcomparison.change.impl;

import com.mlyncar.dp.prototypes.graphcomparison.change.Change;
import com.mlyncar.dp.prototypes.graphcomparison.change.ChangeType;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class ChangeImpl implements Change {

    public String elementId;
    public ChangeType changeType;

    public ChangeImpl(String elementId, ChangeType changeType) {
        this.elementId = elementId;
        this.changeType = changeType;
    }

    @Override
    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    @Override
    public ChangeType getChangeType() {
        return this.changeType;
    }

    @Override
    public String getElementId() {
        return this.elementId;
    }

    @Override
    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

}
