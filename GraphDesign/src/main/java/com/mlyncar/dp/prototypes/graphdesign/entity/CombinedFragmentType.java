package com.mlyncar.dp.prototypes.graphdesign.entity;

import com.mlyncar.dp.prototypes.graphdesign.exception.CombinedFragmentTypeException;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public enum CombinedFragmentType {

    ALT("alternative"),
    OPT("option"),
    LOOP("loop"),
    BREAK("break"),
    PAR("parallel");

    private final String code;

    private CombinedFragmentType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static CombinedFragmentType fromCode(String code) throws CombinedFragmentTypeException {
        for (CombinedFragmentType reason : CombinedFragmentType.values()) {
            if (reason.getCode().equals(code)) {
                return reason;
            }
        }
        throw new CombinedFragmentTypeException("Unknown combined fragment type " + code);
    }
}
