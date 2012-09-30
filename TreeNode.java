import java.util.Set;
import java.util.HashSet;
import static java.lang.System.*;

public class TreeNode {

  public TreeNode parent;

  TreeNode findFirstCommonAncestor(TreeNode other) {
    return TreeNodeHelper.findFirstCommonAncestor(this, other);
  }

  int depth() {
    int result = 0;
    for(TreeNode node = this; node != null; node = node.parent)
      result++;

    return result;
  }

  TreeNode ancestor(int distance) {
    TreeNode node = this;
    for(int i = distance; i >0 && node != null; i--)
      node = node.parent;

    return node;
  }
  
}
