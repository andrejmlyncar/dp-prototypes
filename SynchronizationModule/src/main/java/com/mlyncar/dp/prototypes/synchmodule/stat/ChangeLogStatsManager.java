package com.mlyncar.dp.prototypes.synchmodule.stat;

import com.mlyncar.dp.prototypes.graphcomparison.change.ChangeLog;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class ChangeLogStatsManager {

    private final ChangeLog changelog;

    public ChangeLogStatsManager(ChangeLog changelog) {
        this.changelog = changelog;
    }

    public Integer getNumberOfDeletions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer getNumberOfModifications() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer getNumberOfAdditions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
