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
		parentsLeft.add(this.parent);
		parentsRight.add(other.parent);
		return this.parent.findAncestor(other.parent, parentsLeft, parentsRight);
	}
}
