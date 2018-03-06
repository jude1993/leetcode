/**
 * @Author: jude
 * @Date: Create in 15:20 2018/3/6
 * @Description: Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 */
public class MergeTwoBinaryTrees {
    public TreeNode solution(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return null;
        }
        if(t1 == null){
            t1 = new TreeNode(0);
        }
        if(t2 == null){
            t2 = new TreeNode(0);
        }
        t1.val = t1.val + t2.val;
        solution(t1.left,t2.left);
        solution(t1.right,t1.right);
        return t1;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
