import java.util.Set;
import java.util.HashSet;

public class TreeNode {
  public TreeNode parent;
  TreeNode findFirstCommonAncestor(TreeNode other){
    Set<TreeNode> myAncestors = new HashSet<TreeNode>();
    Set<TreeNode> otherAncestors = new HashSet<TreeNode>();

    TreeNode my = this;

    while (my != null || other != null) {
      if (my != null) {
        myAncestors.add(my);
        my = my.parent;
      }
      if( other != null) {
        otherAncestors.add(other);
        other = other.parent;
      }

      Set<TreeNode> intersection =  new HashSet<TreeNode>(myAncestors);
      intersection.retainAll(otherAncestors);
      if (!intersection.isEmpty())
         return intersection.iterator().next();
    } 

    return null;
  }
}
