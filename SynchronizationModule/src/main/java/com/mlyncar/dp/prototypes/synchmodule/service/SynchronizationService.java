package com.mlyncar.dp.prototypes.synchmodule.service;

import com.mlyncar.dp.prototypes.synchmodule.exception.SynchronizationException;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public interface SynchronizationService {

    public void synchInteractions(String referenceInteractionId, String subInteractionId) throws SynchronizationException;
}
