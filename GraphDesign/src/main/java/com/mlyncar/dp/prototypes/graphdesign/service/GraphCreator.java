package com.mlyncar.dp.prototypes.graphdesign.service;

import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public interface GraphCreator {
    
    public Graph createGraphFromId(String sequenceId);
    
    public Graph createGraphFromSequence(Object sequence);
}
