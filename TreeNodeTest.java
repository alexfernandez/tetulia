import static org.junit.Assert.*;
import org.junit.*;

public class TreeNodeTest {

  @Test public void oneIsParentOfOther() {
    TreeNode one = new TreeNode();
    TreeNode other = new TreeNode();
    other.parent = one;

    assertEquals(one, one.findFirstCommonAncestor(other));
    assertEquals(one, other.findFirstCommonAncestor(one));
  }

  @Test public void oneIsSiblingOfOther() {
    TreeNode one = new TreeNode();
    TreeNode other = new TreeNode();
    TreeNode parent = new TreeNode();
    one.parent = parent;
    other.parent = parent;

    assertEquals(parent, one.findFirstCommonAncestor(other));
    assertEquals(parent, other.findFirstCommonAncestor(one));
  }

  @Test public void oneIsUncleOfOther() {
    TreeNode one = new TreeNode();
    TreeNode other = new TreeNode();
    other.parent = new TreeNode();

    TreeNode oneParent= new TreeNode();
    one.parent = oneParent;
    other.parent.parent = oneParent;

    assertEquals(oneParent, one.findFirstCommonAncestor(other));
    assertEquals(oneParent, other.findFirstCommonAncestor(one));
  }

}
