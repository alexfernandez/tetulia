import java.util.Set;
import java.util.HashSet;

public class TreeNode {

  public TreeNode parent;

  TreeNode findFirstCommonAncestor(TreeNode other) {
    TreeNode one = this; 

     // first calculate the depth diff of between 2 nodes (2n)
     int depthDiff = one.depth() - other.depth();

     // make both nodes to be in the same level
     if (depthDiff > 0)
       one = one.ancestor(depthDiff);
     else
       other = other.ancestor(-depthDiff);

     // now compare the equality
     while (one != other && one != null && other != null){
       one = one.parent;
       other = other.parent;
     }

     return one == null ? null : other;
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
