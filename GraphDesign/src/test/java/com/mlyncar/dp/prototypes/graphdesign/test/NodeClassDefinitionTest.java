package com.mlyncar.dp.prototypes.graphdesign.test;

import com.mlyncar.dp.prototypes.graphdesign.entity.CombinedFragment;
import com.mlyncar.dp.prototypes.graphdesign.entity.CombinedFragmentType;
import com.mlyncar.dp.prototypes.graphdesign.entity.Node;
import com.mlyncar.dp.prototypes.graphdesign.entity.impl.CombinedFragmentImpl;
import com.mlyncar.dp.prototypes.graphdesign.entity.impl.NodeImpl;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class NodeClassDefinitionTest {

    @Test
    public void testNodeClassDefinition() {
        CombinedFragment fragment1 = new CombinedFragmentImpl("Fragment1", CombinedFragmentType.OPT, "condition==true");
        CombinedFragment fragment2 = new CombinedFragmentImpl("Fragment1", CombinedFragmentType.OPT, "condition==true");

        Node node1 = new NodeImpl("TestId", null, null, "Student");
        Node node2 = new NodeImpl("TestId2", null, null, "Student");
        node1.addCombinedFragment(fragment1);
        node2.addCombinedFragment(fragment2);
        assertTrue("Is node equal is throwing incorrect result", node1.isNodeEqual(node2));
    }
}
