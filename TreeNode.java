import java.util.Set;
import java.util.HashSet;

public class TreeNode {
  public TreeNode parent;
  TreeNode findFirstCommonAncestor(TreeNode other){
    Set<TreeNode> myAncestors = new HashSet<TreeNode>();
    Set<TreeNode> otherAncestors = new HashSet<TreeNode>();

    TreeNode my = this;

    boolean flip = true;
    while (my!=null || other!=null) {
      if (myAncestors.contains(other))
         return other;
      if (otherAncestors.contains(my))
         return my;

      if (flip) {
        flip = false;
        if (my != null) {
          myAncestors.add(my);
          my = my.parent;
          continue;
        }
      }
      if (!flip) {
        flip = true;
        if (other != null) {
          otherAncestors.add(other);
          other = other.parent;
          continue;
        }
      }
    } 

    return null;
  }
}
