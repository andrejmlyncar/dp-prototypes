/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlyncar.dp.prototypes.graphdesign.entity.impl;

import com.mlyncar.dp.prototypes.graphdesign.entity.CombinedFragment;
import com.mlyncar.dp.prototypes.graphdesign.entity.CombinedFragmentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class CombinedFragmentImpl implements CombinedFragment {

    private String name;
    private CombinedFragmentType combinedFragmentType;
    private String fragmentBody;
    private final Logger logger = LoggerFactory.getLogger(CombinedFragmentImpl.class);

    public CombinedFragmentImpl(String name, CombinedFragmentType combinedFragmentType, String fragmentBody) {
        this.name = name;
        this.combinedFragmentType = combinedFragmentType;
        this.fragmentBody = fragmentBody;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public CombinedFragmentType getCombinedFragmentType() {
        return this.combinedFragmentType;
    }

    @Override
    public void setCombinedFragmentType(CombinedFragmentType combinedFragmentType) {
        this.combinedFragmentType = combinedFragmentType;
    }

    @Override
    public String getFragmentBody() {
        return this.fragmentBody;
    }

    @Override
    public void setFragmentBody(String fragmentBody) {
        this.fragmentBody = fragmentBody;
    }

    @Override
    public boolean isFragmentEqual(CombinedFragment combinedFragment) {
        this.logger.debug("Checking equality of combined fragment {} with {} ", combinedFragment.getName(), this.getName());
        return combinedFragment.getCombinedFragmentType().getCode().equals(this.getCombinedFragmentType().getCode())
                && combinedFragment.getName().equals(this.getName())
                && combinedFragment.getFragmentBody().equals(this.getFragmentBody());
    }

}
