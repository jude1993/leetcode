import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * @Author: jude
 * @Date: Create in 15:20 2018/3/6
 * @Description: Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 * 合并树
 */
public class MergeTwoBinaryTrees_617 {
    public TreeNode solution(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            t1 = new TreeNode(0);
        }
        if (t2 == null) {
            t2 = new TreeNode(0);
        }
        int val = t1.val + t2.val;
        TreeNode treeNode = new TreeNode(val);
        solution(t1.left, t2.left);
        solution(t1.right, t1.right);
        return treeNode;
    }

    public TreeNode solution2(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode treeNode = new TreeNode(val);
        treeNode.left = solution(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        treeNode.right = solution(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return treeNode;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;


        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }

    @Getter
    @Setter
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "val= " + val + "; left= " + left + "; right= " + right;
        }
    }

    static TreeNode getTreeNode(List<Integer> valList, int index) {
        if (valList.size() - 1 < index) {
            return null;
        }
        System.out.println(valList);
        System.out.println(index);
        return getTreeNode(valList, index++);
    }
}
