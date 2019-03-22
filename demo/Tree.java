import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：wupeng
 * @date ：Created in 10:16 2018/10/24
 * @description：
 */
@Getter
@Setter
@ToString
class Tree<T> {
  private Tree<T> left;
  private Tree<T> right;
  private T value;

  Tree() {}

  Tree(T value) {
    this.value = value;
  }

  Tree(T left, T right, T value) {
    this.left = new Tree<>(left);
    this.right = new Tree<>(right);
    this.value = value;
  }

  Boolean hasLeft() {
    return this.left != null;
  }

  Boolean hasRight() {
    return this.right != null;
  }

  Boolean hasChild() {
    return this.left != null || this.right != null;
  }
}
