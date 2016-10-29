package com.mlyncar.dp.prototypes.graphcomparison.test;

import com.mlyncar.dp.prototypes.graphcomparison.service.ComparisonService;
import com.mlyncar.dp.prototypes.graphcomparison.service.impl.ComparisonServiceImpl;
import com.mlyncar.dp.prototypes.graphdesign.entity.Graph;
import com.mlyncar.dp.prototypes.graphdesign.entity.Message;
import com.mlyncar.dp.prototypes.graphdesign.entity.MessageType;
import com.mlyncar.dp.prototypes.graphdesign.entity.Node;
import com.mlyncar.dp.prototypes.graphdesign.entity.impl.MessageImpl;
import com.mlyncar.dp.prototypes.graphdesign.entity.impl.NodeImpl;
import com.mlyncar.dp.prototypes.graphdesign.entity.impl.TreeGraph;
import java.util.UUID;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class SubTreeFindTest {

    private Graph createThreeNodeGraph1() {
        Node rootNode = new NodeImpl(UUID.randomUUID().toString(), null, null, "Student");
        Graph graph = new TreeGraph(rootNode);
        Message message1 = new MessageImpl("askTeacher()", MessageType.SYNCH);
        Message message2 = new MessageImpl("visitClassroom()", MessageType.SYNCH);
        Node node1 = new NodeImpl(UUID.randomUUID().toString(), message1, rootNode, "Teacher");
        Node node2 = new NodeImpl(UUID.randomUUID().toString(), message2, rootNode, "Classroom");
        rootNode.addChildNode(node1);
        rootNode.addChildNode(node2);
        return graph;
    }

    private Graph createThreeNodeGraph2() {
        Node rootNode = new NodeImpl(UUID.randomUUID().toString(), null, null, "Student");
        Graph graph = new TreeGraph(rootNode);
        Message message1 = new MessageImpl("askTeacher()", MessageType.SYNCH);
        Message message2 = new MessageImpl("visitStudyDepartment()", MessageType.SYNCH);
        Node node1 = new NodeImpl(UUID.randomUUID().toString(), message1, rootNode, "Teacher");
        Node node2 = new NodeImpl(UUID.randomUUID().toString(), message2, rootNode, "StudyDepartment");
        rootNode.addChildNode(node1);
        rootNode.addChildNode(node2);
        return graph;
    }

    private Graph createFiveNodeGraph1() {
        Node rootNode = new NodeImpl(UUID.randomUUID().toString(), null, null, "Teacher");
        Graph graph = new TreeGraph(rootNode);
        Message message1 = new MessageImpl("addAssignment()", MessageType.SYNCH);
        Message message2 = new MessageImpl("teach()", MessageType.ASYNCH);

        Node node1 = new NodeImpl(UUID.randomUUID().toString(), message1, rootNode, "Student");
        Node node2 = new NodeImpl(UUID.randomUUID().toString(), message2, rootNode, "Classroom");
        rootNode.addChildNode(node1);
        rootNode.addChildNode(node2);
        Message message3 = new MessageImpl("askTeacher()", MessageType.SYNCH);
        Message message4 = new MessageImpl("visitClassroom()", MessageType.SYNCH);

        Node node3 = new NodeImpl(UUID.randomUUID().toString(), message3, rootNode, "Teacher");
        Node node4 = new NodeImpl(UUID.randomUUID().toString(), message4, rootNode, "Classroom");
        node1.addChildNode(node3);
        node1.addChildNode(node4);
        return graph;
    }

    private Graph createFiveNodeGraph2() {
        Node rootNode = new NodeImpl(UUID.randomUUID().toString(), null, null, "Teacher");
        Graph graph = new TreeGraph(rootNode);
        Message message1 = new MessageImpl("addAssignment()", MessageType.SYNCH);
        Message message2 = new MessageImpl("teach()", MessageType.ASYNCH);

        Node node1 = new NodeImpl(UUID.randomUUID().toString(), message1, rootNode, "Student");
        Node node2 = new NodeImpl(UUID.randomUUID().toString(), message2, rootNode, "Classroom");
        rootNode.addChildNode(node2);
        rootNode.addChildNode(node1);
        Message message3 = new MessageImpl("askTeacher()", MessageType.SYNCH);
        Message message4 = new MessageImpl("visitClassroom()", MessageType.SYNCH);

        Node node3 = new NodeImpl(UUID.randomUUID().toString(), message3, rootNode, "Teacher");
        Node node4 = new NodeImpl(UUID.randomUUID().toString(), message4, rootNode, "Classroom");
        node1.addChildNode(node3);
        node1.addChildNode(node4);
        return graph;
    }

    @Test
    public void shouldFindOneNodeSubtreeInThreeNodeTree() {
        System.out.println("RUNNING shouldFindOneNodeSubtreeInThreeNodeTree");
        ComparisonService service = new ComparisonServiceImpl();
        Message message = new MessageImpl("visitClassroom()", MessageType.SYNCH);
        Node node = new NodeImpl(UUID.randomUUID().toString(), message, null, "Classroom");
        Graph graph = new TreeGraph(node);
        assertTrue("Graph with one node is not subtree of three node tree even when same node is in reference graph", service.isGraphSubgraph(createThreeNodeGraph1(), graph));
    }

    @Test
    public void shouldFindThreeNodeSubtreeInThreeNodeTree() {
        System.out.println("RUNNING shouldFindThreeNodeSubtreeInThreeNodeTree");
        ComparisonService service = new ComparisonServiceImpl();
        assertTrue("One graph same as reference graph is not considered as subgraph", service.isGraphSubgraph(createThreeNodeGraph1(), createThreeNodeGraph1()));
    }

    @Test
    public void shouldFailsToFindOneNodeSubtreeInThreeNodeTree() {
        System.out.println("RUNNING shouldFailsToFindOneNodeSubtreeInThreeNodeTree");
        ComparisonService service = new ComparisonServiceImpl();
        Message message = new MessageImpl("visitStudyDepartment()", MessageType.SYNCH);
        Node node = new NodeImpl(UUID.randomUUID().toString(), message, null, "StudyDepartment");
        Graph graph = new TreeGraph(node);
        assertFalse("Tree with one node is considered as subtree even when it is not located in reference tree", service.isGraphSubgraph(createThreeNodeGraph1(), graph));
    }

    @Test
    public void shouldFailsToFindThreeNodeSubtreeInThreeNodeTree() {
        System.out.println("RUNNING shouldFailsToFindThreeNodeSubtreeInThreeNodeTree");
        ComparisonService service = new ComparisonServiceImpl();
        assertFalse("Graph with three nodes is not subtree of three node tree even when same nodes are in reference graph", service.isGraphSubgraph(createThreeNodeGraph1(), createThreeNodeGraph2()));
    }

    @Test
    public void shouldFindThreeNodeSubtreeInFiveNodeTree() {
        System.out.println("RUNNING shouldFindThreeNodeSubtreeInFiveNodeTree");
        ComparisonService service = new ComparisonServiceImpl();
        assertTrue("Graph with three nodes is not subtree even when it should be", service.isGraphSubgraph(createFiveNodeGraph1(), createThreeNodeGraph1()));
    }

    @Test
    public void shouldFailsToFindThreeNodeSubtreeInFiveNodeTree() {
        System.out.println("RUNNING shouldFailsToFindThreeNodeSubtreeInFiveNodeTree");
        ComparisonService service = new ComparisonServiceImpl();
        assertFalse("Graph with three nodes is considered as subtree even when it is not subtree", service.isGraphSubgraph(createFiveNodeGraph1(), createThreeNodeGraph2()));
    }

    @Test
    public void shouldFindThreeNodeSubtreeInFiveNodeTreeWhenSubtreeIsSecondLeaf() {
        System.out.println("RUNNING shouldFindThreeNodeSubtreeInFiveNodeTree");
        ComparisonService service = new ComparisonServiceImpl();
        assertTrue("Graph with three nodes is not subtree even when it should be", service.isGraphSubgraph(createFiveNodeGraph2(), createThreeNodeGraph1()));
    }
}
