package com.mlyncar.dp.prototypes.graphcomparison.change;

import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;
import java.util.List;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public interface ChangeLog {

    public Graph getReferenceGraph();

    public Graph getSubGraph();

    public void addChange(Change change);

    public List<Change> changes();
    
    public String getReferenceInteractionId();
    
    public String getSubInteractionId();
    
}
