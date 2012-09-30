import static org.junit.Assert.*;
import org.junit.*;

public class TreeNodeTest {

  @Test public void oneIsParentOfOther() {
    TreeNode one = new TreeNode();
    TreeNode other = new TreeNode();
    other.parent = one;

    assertEquals(one, TreeNodeHelper.findCommonAncestor(one, other));
    assertEquals(one, TreeNodeHelper.findCommonAncestor(other, one));
  }

  @Test public void oneIsSiblingOfOther() {
    TreeNode one = new TreeNode();
    TreeNode other = new TreeNode();
    one.parent = other.parent = new TreeNode();

    assertEquals(one.parent, TreeNodeHelper.findCommonAncestor(one, other));
    assertEquals(one.parent, TreeNodeHelper.findCommonAncestor(other, one));
  }

  @Test public void oneIsUncleOfOther() {
    TreeNode one = new TreeNode();
    TreeNode other = new TreeNode();
    other.parent = new TreeNode();
    one.parent = other.parent.parent = new TreeNode();

    assertEquals(one.parent, TreeNodeHelper.findCommonAncestor(one, other));
    assertEquals(one.parent, TreeNodeHelper.findCommonAncestor(other, one));
  }

}
