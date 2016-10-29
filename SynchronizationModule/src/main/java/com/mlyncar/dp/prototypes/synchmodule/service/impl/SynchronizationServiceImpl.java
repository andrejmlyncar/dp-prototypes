package com.mlyncar.dp.prototypes.synchmodule.service.impl;

import com.mlyncar.dp.prototypes.graphcomparison.change.Change;
import com.mlyncar.dp.prototypes.graphcomparison.change.ChangeLog;
import com.mlyncar.dp.prototypes.graphcomparison.service.ComparisonService;
import com.mlyncar.dp.prototypes.graphcomparison.service.impl.ComparisonServiceImpl;
import com.mlyncar.dp.prototypes.synchmodule.service.SynchronizationService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class SynchronizationServiceImpl implements SynchronizationService {

    @Override
    public void synchInteractions(String referenceInteractionId, String subInteractionId) {
        ComparisonService comparisonService = new ComparisonServiceImpl();

        ChangeLog changelog = comparisonService.getChangesInTwoGraphs(referenceInteractionId, subInteractionId);
        if (changelog.changes().isEmpty()) {
            //no changes detected - popup into screen and one record to changelog
        } else {
            List<Change> changesToApplyUml = new ArrayList<>();
            List<Change> changesToApplyLog = new ArrayList<>();
            changelog.changes().stream().map((change) -> {
                if (shouldApplyChangesToChangeLog(change)) {
                    changesToApplyUml.add(change);
                }
                return change;
            }).filter((change) -> (shouldApplyChangesToUml(change))).forEachOrdered((change) -> {
                changesToApplyLog.add(change);
            });
            applyChangesToUml(changesToApplyUml, subInteractionId);
            applyChangesToChangeLog(changesToApplyLog, subInteractionId);
        }

    }

    private boolean shouldApplyChangesToUml(Change change) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private boolean shouldApplyChangesToChangeLog(Change change) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void applyChangesToUml(List<Change> changes, String interactionId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void applyChangesToChangeLog(List<Change> changes, String interactionId) {
        throw new UnsupportedOperationException("Not supported yet");
    }

}
