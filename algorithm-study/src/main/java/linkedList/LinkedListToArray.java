package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdyujing7 on 2018/8/12.
 */
public class LinkedListToArray {

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.setValue(1);
        Node node2 = new Node();
        node2.setValue(2);
        node1.setNext(node2);
        List<Node> list = reverse(node1);
        for (Node node : list) {
            System.out.println(node.getValue());
        }
    }

    public static List<Node> reverse(Node node) {
        if (node == null) {
            return null;
        }
        List<Node> list = new ArrayList<Node>();
        while (node != null) {
            list.add(0, node);
            node = node.getNext();
        }
        return list;
    }
}
