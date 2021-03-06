package com.mlyncar.dp.prototypes.graphdesign.entity.impl;

import com.mlyncar.dp.prototypes.graphdesign.entity.CombinedFragment;
import com.mlyncar.dp.prototypes.graphdesign.entity.Message;
import com.mlyncar.dp.prototypes.graphdesign.entity.Node;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class NodeImpl implements Node {

    private final List<Node> childNodes = new ArrayList<>();
    private String name;
    private Node parentNode;
    private Message createMessage;
    private String id;
    private final List<CombinedFragment> combinedFragments = new ArrayList<>();
    private final Logger logger = LoggerFactory.getLogger(NodeImpl.class);

    public NodeImpl(String id, Message createMessage, Node parentNode, String name) {
        this.id = id;
        this.createMessage = createMessage;
        this.parentNode = parentNode;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Node getParentNode() {
        return this.parentNode;
    }

    @Override
    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public List<Node> childNodes() {
        return this.childNodes;
    }

    @Override
    public void addChildNode(Node newNode) {
        this.childNodes.add(newNode);
    }

    @Override
    public void addChildNode(Node newNode, Node leftNeighbour) {
        this.childNodes.add(this.childNodes.indexOf(leftNeighbour) + 1, newNode);
    }

    @Override
    public void removeChildNode(Node node) {
        this.childNodes().remove(node);
    }

    @Override
    public void removeChildNode(String id) {
        for (Node childNode : childNodes) {
            if (childNode.getId().equals(id)) {
                childNodes.remove(childNode);
            }
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Message getCreateMessage() {
        return this.createMessage;
    }

    @Override
    public void setCreateMessage(Message createMessage) {
        this.createMessage = createMessage;
    }

    @Override
    public void addCombinedFragment(CombinedFragment combinedFragment) {
        this.combinedFragments.add(combinedFragment);
    }

    @Override
    public void removeCombinedFragment(CombinedFragment combinedFragment) {
        this.combinedFragments.remove(combinedFragment);
    }

    @Override
    public List<CombinedFragment> combinedFragments() {
        return this.combinedFragments;
    }

    @Override
    public boolean isLeaf() {
        return this.childNodes.isEmpty();
    }

    @Override
    public boolean isNodeEqual(Node node) {
        this.logger.debug("Comparing node {} and {}", node.getId(), this.getId());
        if (node.getName().equals(this.getName())) {
            if (node.getCreateMessage() != null) {
                if (node.getCreateMessage().isMessageEqual(this.getCreateMessage())) {
                    return compareCombinedFragments(node);
                } else {
                    return false;
                }
            }
            return compareCombinedFragments(node);
        } else {
            this.logger.debug("Name and Create message is NOT equal");
            return false;
        }
    }

    private boolean compareCombinedFragments(Node node) {
        int fragmentIndex = 0;
        for (CombinedFragment fragment : combinedFragments()) {
            if (fragment.isFragmentEqual(node.combinedFragments().get(fragmentIndex))) {
                fragmentIndex++;
            } else {
                return false;
            }
        }
        return true;
    }
}
