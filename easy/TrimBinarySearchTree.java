import lombok.ToString;
import org.junit.jupiter.api.Test;

/**
 * @Author: jude
 * @Date: Create in 10:59 2018/3/14
 * @Description:Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree,
 *                      so the result should return the new root of the trimmed binary search tree.
 */
public class TrimBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }
        if(root.val<L){
            return trimBST(root.right, L,R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;
    }

    public TreeNode trimNode2(TreeNode root, int L, int R){
        if(root == null){
            return null;
        }
        if(root.val<L){
            return trimBST(root.right, L,R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if(root.val >L && root.val < R){
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
        }
        if(root.val == L){
            root.left = null;
            root.right = trimBST(root.right,L,R);
        }
        if(root.val == R){
            root.left = trimBST(root.left,L,R);
            root.right = null;
        }
        return root;
    }

    @Test
    public void testTree() {
        TreeNode root = new TreeNode(new TreeNode(0), new TreeNode(2), 1);
        TreeNode treeNode = trimBST(root, 1, 2);
        System.out.println(treeNode);
    }
}

@ToString
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(TreeNode L, TreeNode R, int value) {
        this.left = L;
        this.right = R;
        this.val = value;
    }

    TreeNode(int value) {
        this.val = value;
    }
}
