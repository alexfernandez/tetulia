public class TreeNodeHelper {
	
	public static TreeNode findFirstCommonAncestor(final TreeNode _one, final TreeNode _other) {
		TreeNode commonAncestor = null, one = _one, other = _other;

		// first I'm going to calculate the deep of each node (2n)
		int depthDiff = one.depth() - other.depth();

		// first I don't need to check equality
		if (depthDiff > 0) 
                  one = one.ancestor(depthDiff);
                else
                  other = other.ancestor(-depthDiff);

		// now I need to compare the equality
		while (commonAncestor == null) {
			if (one == other) {
				commonAncestor = one;
			} else {
				one = one.parent;
				other = other.parent;
			}
		}

		return commonAncestor;

	}
}
