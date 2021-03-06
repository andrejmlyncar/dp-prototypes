package com.mlyncar.dp.prototypes.graphcomparison.change;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public interface Change {

    public void setChangeType(ChangeType changeType);

    public ChangeType getChangeType();

    public String getElementId();

    public void setElementId(String elementId);

    public void setChangeLevel(ChangeLevel changeLevel);

    public ChangeLevel getChangeLevel();
    
    public String getNewValue();
    
    public void setNewValue(String value);
    
    public String getOldValue();
    
    public void setOldValue(String oldValue);
}
