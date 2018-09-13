package btree.travel;

/**
 * Created by cdyujing7 on 2018/8/22.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class PreAndMiddleTravel {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = reConstructBinaryTree(pre, in);
        System.out.println(node);
    }


    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        func(0, 0, pre.length - 1, node, pre, in);
        return node;
    }

    private static void func(int index, int start, int end, TreeNode node, int[] pre, int[] in) {
        if (index == end - 1) {
            if (pre[index] == in[start]) {
                node.right = new TreeNode(pre[end]);
            } else {
                node.left = new TreeNode(pre[end]);
            }
        } else if (index < end -1){
            int edge = start;
            for (int i = start; i <= end; i++) {
                if (pre[index] == in[i]) {
                    edge = i;
                    break;
                }
            }
            if (edge == start) {
                node.right = new TreeNode(pre[index + 1]);
                func(index+1, start+1, end, node.right, pre, in);
            } else if (edge == end) {
                node.left = new TreeNode(pre[index + 1]);
                func(index+1,start, end - 1, node.left, pre, in);
            } else {
                node.left = new TreeNode(pre[index + 1]);
                func(index+1,start, edge - 1, node.left, pre, in);
                node.right = new TreeNode(pre[edge + 1]);
                func(edge+1, edge+1, end, node.right, pre, in);
            }
        }
    }

}
