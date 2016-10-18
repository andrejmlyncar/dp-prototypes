/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlyncar.dp.prototypes.graphdesign.entity.impl;

import com.mlyncar.dp.prototypes.graphdesign.entity.CombinedFragment;
import com.mlyncar.dp.prototypes.graphdesign.entity.CombinedFragmentType;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class CombinedFragmentImpl implements CombinedFragment {

    private String name;
    private CombinedFragmentType combinedFragmentType;
    private String fragmentBody;

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

}
