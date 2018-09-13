package btree.depth;

import btree.diamter.Node;

/**
 * Created by cdyujing7 on 2018/7/8.
 */
public class MaxDepth {
    public static void main(String[] args) {
        Node parent = new Node();
        Node leftOne = new Node();
        parent.setLeft(leftOne);
        Node leftTwo = new Node();
        leftOne.setLeft(leftTwo);
        Node leftThree = new Node();
        leftTwo.setLeft(leftThree);
        Node leftFour = new Node();
        leftThree.setLeft(leftFour);
        Node rightFour = new Node();
        leftThree.setRight(rightFour);
        Node leftFive = new Node();
        leftFour.setLeft(leftFive);
        Node leftSix = new Node();
        leftFive.setLeft(leftSix);
        Node five = new Node();
        rightFour.setLeft(five);
        Node fiveAdd = new Node();
        rightFour.setRight(fiveAdd);
        System.out.println("depth:" + maxDepth(parent));
    }

    public static Integer maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        Integer left = maxDepth(node.getLeft());
        Integer right = maxDepth(node.getRight());
        return left > right ? left + 1 : right + 1;
    }
}
