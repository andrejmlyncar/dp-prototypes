package com.mlyncar.dp.prototypes.graphdesign.entity;

import java.util.List;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public interface Node {

    public Message getCreateMessage();

    public void setCreateMessage(Message message);

    public String getId();

    public void setId(String id);

    public String getName();

    public void setName(String name);

    public Node getParentNode();

    public void setParentNode(Node node);

    public List<Node> childNodes();

    public void addChildNode(Node node);

    public void addChildNode(Node node, Node leftNeighbour);

    public void removeChildNode(Node node);

    public void removeChildNode(String id);

    public List<CombinedFragment> combinedFragments();

    public void addCombinedFragment(CombinedFragment combinedFragment);

    public void removeCombinedFragment(CombinedFragment combinedFragment);

    public boolean isNodeEqual(Node node);
    
    public boolean isLeaf();
}
