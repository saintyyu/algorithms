package btree.width;

import btree.diamter.Node;

import java.util.LinkedList;

/**
 * Created by cdyujing7 on 2018/7/8.
 */
public class Main {

    public static void main(String[] args) {
        Node parent = new Node();
        System.out.println("width:" + calWidth(parent));
    }

    public static Integer calWidth(Node node) {
        if (node == null) {
            return 0;
        }
        LinkedList<Node> linkedList = new LinkedList<Node>();
        linkedList.addFirst(node);

        Integer lastWidth = 1;
        Integer currentWidth = linkedList.size();
        Integer maxWidth = currentWidth;
        while (!linkedList.isEmpty()) {
            while (lastWidth != 0) {
                Node currentNode = linkedList.pollFirst();
                    if (currentNode.getLeft() != null) {
                    linkedList.addLast(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    linkedList.addLast(currentNode.getRight());
                }
                lastWidth--;
            }
            currentWidth = linkedList.size();
            maxWidth = maxWidth > currentWidth ? maxWidth : currentWidth;
            lastWidth = currentWidth;
        }
        return maxWidth;
    }
}
