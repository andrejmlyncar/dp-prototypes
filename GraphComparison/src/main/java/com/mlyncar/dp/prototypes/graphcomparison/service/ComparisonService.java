/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlyncar.dp.prototypes.graphcomparison.service;

import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public interface ComparisonService {
    
    public void findSubTree(Graph referenceTree, Graph subTree);
    
    public ComparisonService getInstance();
}
