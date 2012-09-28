import java.util.Set;
import java.util.HashSet;

public class TreeNode {
  public TreeNode parent;
  TreeNode findFirstCommonAncestor(TreeNode other){
    Set<TreeNode> myAncestors = new HashSet<TreeNode>();
    Set<TreeNode> otherAncestors = new HashSet<TreeNode>();

    TreeNode my = this;

    while (my!=null || other!=null) {
      if (myAncestors.contains(other))
         return other;
      if (otherAncestors.contains(my))
         return my;

      if (my != null) {
        myAncestors.add(my);
        my = my.parent;
        continue;
      }
      if (other != null) {
        otherAncestors.add(other);
        other = other.parent;
        continue;
      }
    } 

    return null;
  }
}
