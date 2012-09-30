import java.util.Set;
import java.util.HashSet;
import static java.lang.System.*;

public class TreeNode {

  public TreeNode parent;

  TreeNode findFirstCommonAncestor(TreeNode other) {
    TreeNode result = null, one = this; 

     // first calculate the depth dif of between 2 nodes (2n)
     int depthDiff = one.depth() - other.depth();

     // make both nodes to be in the same level
     if (depthDiff > 0)
       one = one.ancestor(depthDiff);
     else
       other = other.ancestor(-depthDiff);

     // now compare the equality
     while (result == null) { 
       if (one == other) {
         result = one;
       } else {
         one = one.parent;
         other = other.parent;
       }
     }
     return result;
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
