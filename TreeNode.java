import java.util.ArrayList;

public class TreeNode {

	public TreeNode parent;

	TreeNode findFirstCommonAncestor(TreeNode other)
	{
		ArrayList<TreeNode> left = new ArrayList<TreeNode>();
		ArrayList<TreeNode> right = new ArrayList<TreeNode>();
		return this.findAncestor(other, left, right);
	}

	TreeNode findAncestor(TreeNode other, ArrayList<TreeNode> parentsLeft, ArrayList<TreeNode> parentsRight)
	{
		if (this == other)
		{
			return this;
		}
		if (parentsRight.contains(this))
		{
			return this;
		}
		if (parentsLeft.contains(other))
		{
			return other;
		}
		if (this.parent == null && other.parent == null)
		{
			return null;
		}
		TreeNode left = this;
		if (this.parent != null)
		{
			left = this.parent;
			parentsLeft.add(this.parent);
		}
		TreeNode right = other;
		if (other.parent != null)
		{
			right = other.parent;
			parentsRight.add(other.parent);
		}
		return left.findAncestor(right, parentsLeft, parentsRight);
	}
}
