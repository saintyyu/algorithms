package btree.depth;

import btree.diamter.Node;

/**
 * Created by cdyujing7 on 2018/7/8.
 */
public class MinDepth {

    public static void main(String[] args) {

    }

    public Integer minDepth(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null) {
            return minDepth(node.getRight()) + 1;
        }
        if (node.getRight() == null) {
            return minDepth(node.getLeft()) + 1;
        }
        Integer left = minDepth(node.getLeft()) + 1;
        Integer right = minDepth(node.getRight()) + 1;
        return left > right ? right : left;
    }
}
