import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        System.out.println(t1.val);
        solution(t1.left,t2.left);
        solution(t1.right,t1.right);
        return t1;
    }

    @Getter
    @Setter
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return "val= "+val+"; left= "+left+"; right= "+right;
        }
    }

    static TreeNode getTreeNode(List<Integer> valList,int index){
        if(valList.size()-1<index){
            return null;
        }
        System.out.println(valList);
        System.out.println(index);
        return getTreeNode(valList,index++);
    }
    @Test
    public void testSolution(){
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,2,5,null,2);
        List<Integer> list2 = new ArrayList<Integer>();
        Collections.addAll(list2,2,1,3,null,4,null,7);
        solution(getTreeNode(list,0),getTreeNode(list2,0));
    }

}
