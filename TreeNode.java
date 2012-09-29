import java.util.Set;
import java.util.HashSet;
import static java.lang.System.*;

public class TreeNode {
  public static int stepSize = 8;

  public TreeNode parent;
  TreeNode findFirstCommonAncestor(TreeNode other){
    Set<TreeNode> myAncestors = new HashSet<TreeNode>();
    Set<TreeNode> otherAncestors = new HashSet<TreeNode>();

    TreeNode my = this;

    int step = stepSize + 1;
    while (my!=null || other!=null) {
      if (myAncestors.contains(other))
         return other;
      if (otherAncestors.contains(my))
         return my;

      if (step> 1) {
        step--;
        if (my != null) {
          myAncestors.add(my);
          my = my.parent;
          continue;
        } 
      }
      if (step == 1 || my == null)
        step = -(stepSize + 1);
      if (step == -1 || other == null)
        step = stepSize + 1;

      if (step< -1) {
        step++;
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
