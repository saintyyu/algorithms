package btree.diamter;

/**
 * Created by cdyujing7 on 2018/7/8.
 */
public class Main {
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
        System.out.println("diameter:" + calDiameter(parent).getDiameter());
    }

    public static Pair calDiameter(Node node) {
        Pair pair = new Pair();
        if (node == null) {//空节点
            return pair;
        }
        if (node.getLeft() == null && node.getRight() == null) {//左右节点均为空
            pair.setDeep(1);
            pair.setDiameter(1);
        }
        Pair left = calDiameter(node.getLeft());
        Pair right = calDiameter(node.getRight());
        pair.setDeep(left.getDeep() > right.getDeep() ? left.getDeep() + 1 : right.getDeep() + 1);//设置当前节点深度
        Integer diameter = left.getDiameter() > right.getDiameter() ? left.getDiameter() : right.getDiameter();
        pair.setDiameter(left.getDeep() + right.getDeep() + 1 > diameter ? left.getDeep() + right.getDeep() + 1 : diameter);
        return pair;

    }
}
