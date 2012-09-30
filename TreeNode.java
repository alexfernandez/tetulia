import java.util.Set;
import java.util.HashSet;
import static java.lang.System.*;

public class TreeNode {

  public TreeNode parent;
  TreeNode findFirstCommonAncestor(TreeNode other) {
    return TreeNodeHelper.findFirstCommonAncestor(this, other);
  }
  
}
