package ru.vsu.cs.tarantsov.parsers;

import ru.vsu.cs.tarantsov.node.AbstractTreeNode;

public interface Parser {
    public AbstractTreeNode parse(String content);
}
