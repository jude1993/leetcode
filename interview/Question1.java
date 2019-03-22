import java.util.Stack;

/**
 * @author ：wupeng
 * @date ：Created in 15:59 2018/12/19
 * @description：层次遍历树并输出每层的层级
 */
public class Question1 {
  public static void main(String[] args) {
    int level = 1;
    Stack<Integer> stack = new Stack<>();
    Tree root = buildTree();
    Tree temp = root;
    while (temp.hasChild()) {
      System.out.println(temp.getValue());
      temp = temp.getLeft();
    }
  }

  public static Tree buildTree() {
    Tree<Integer> root = new Tree<>(3);
    Tree<Integer> left = new Tree<>(4, 6, 5);
    Tree<Integer> right = new Tree<>(7, 9, 8);
    root.setLeft(left);
    root.setRight(right);
    return root;
  }
}
