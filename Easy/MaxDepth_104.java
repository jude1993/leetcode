/**
 * Created by jude on 2018/4/13.
 */
public class MaxDepth_104 {
    public int maxDepth(TreeNode root){
        if(root.left == null && root.right == null){

        }
        return -1;
    }


    private int getDepth(TreeNode root, int depth){
        if(root.left == null && root.right == null){
            return depth;
        }
        return -1;
    }
}
