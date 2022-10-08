package ru.vsu.cs.tarantsov.node;

import ru.vsu.cs.tarantsov.node.AbstractTreeNode;

import java.util.ArrayList;
import java.util.List;

public class MyTreeNode extends AbstractTreeNode {

    String tagName;
    List<AbstractTreeNode> children = new ArrayList<>();

    public MyTreeNode(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

    public List<AbstractTreeNode> getChildren() {
        return children;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setChildren(List<AbstractTreeNode> children) {
        this.children = children;
    }

    public void addChild(AbstractTreeNode abstractTreeNode) {
        this.children.add(abstractTreeNode);
    }

}
