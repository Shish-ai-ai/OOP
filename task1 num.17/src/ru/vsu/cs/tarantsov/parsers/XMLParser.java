package ru.vsu.cs.tarantsov.parsers;


import ru.vsu.cs.tarantsov.node.AbstractTreeNode;
import ru.vsu.cs.tarantsov.node.MyTreeNode;
import ru.vsu.cs.tarantsov.node.SimpleTreeNode;


import java.util.Stack;

public class XMLParser implements Parser {

    private int index = 0;
    private String content = "";
    Stack<MyTreeNode> stack = new Stack<>();

    @Override
    public AbstractTreeNode parse(String content) {
        this.content = content;

        return readTagName();
    }



    private AbstractTreeNode readTagName() {
        if (content.length() <= index) {
            return null;
        }
        StringBuilder temp = new StringBuilder();
        while (content.charAt(index) != '>') {
            temp.append(content.charAt(index));
            index++;
        }
        temp.append(content.charAt(index));

        index++;

        MyTreeNode treeNode = new MyTreeNode(temp.toString());
        if (!stack.isEmpty()) {
            stack.peek().addChild(treeNode);
        }
        stack.push(treeNode);
        ifSimpleTreeNode();


        return treeNode;
    }

    private void ifSimpleTreeNode() {
        if (content.length() <= index) {
            return;
        }
        StringBuilder temp = new StringBuilder();
        while (content.length() > index && content.charAt(index) != '<') {
            temp.append(content.charAt(index));
            index++;
        }

        if (index >= content.length()) {
            return;
        }
        if (temp.length() > 0 && content.charAt(index) == '<' && content.charAt(index + 1) == '/' &&
                (content.chars().filter(x -> x != ' ').filter(x -> x != '\n').filter(x -> x != '\t').count() > 0)) {
            SimpleTreeNode simpleTreeNode = new SimpleTreeNode(temp.toString());
            stack.peek().addChild(simpleTreeNode);
            ifSimpleTreeNode();
        } else {
            openCloseTag();

        }
    }

    private void openCloseTag() {
        if (content.charAt(index + 1) == '/') {
            readCloseTag();
        } else {
            readTagName();
        }
    }

    private void readCloseTag() {
        if (content.length() <= index) {
            return;
        }

        stack.pop();
        while (content.length() > index && content.charAt(index) != '>') {

            index++;
        }
        //index++;

        while (content.length() > index && content.charAt(index) != '<') {

            index++;
        }
        ifSimpleTreeNode();
    }
}
