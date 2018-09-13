package btree.parent;

import btree.diamter.Node;

/**
 * Created by cdyujing7 on 2018/8/7.
 */
public class ClosestParent {

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.setValue("1");
        Node node2 = new Node();
        node2.setValue("2");
        node2.setParent(node1);
        Node node3 = new Node();
        node3.setValue("3");
        node3.setParent(node1);
        Node node4 = new Node();
        node4.setValue("4");
        node4.setParent(node2);
        Node node5 = new Node();
        node5.setValue("5");
        node5.setParent(node4);
        Node node6 = new Node();
        node6.setValue("6");
        node6.setParent(node4);
        System.out.println(closestParent(node5, node6).getValue());
    }

    public static Node closestParent(Node node1, Node node2) {
        boolean flag = false;
        Node result = null;
        if (node1 == null || node2 == null) {
            return result;
        }
        while (node1.getParent() != null) {
            Node tmp = node2;
            while (tmp.getParent() != null) {
                if (node1.getParent().equals(tmp.getParent())) {
                    result = node1.getParent();
                    flag = true;
                    break;
                }
                tmp = tmp.getParent();
            }
            if (flag) {
                break;
            }
            node1 = node1.getParent();
        }
        return result;
    }
}
