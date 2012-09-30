public class TreeNodeHelper {
	
	public static TreeNode findFirstCommonAncestor(final TreeNode _one, final TreeNode _two) {

		// first I'm going to calculate the deep of each node (2n)
		int oneDeep = 1,
			twoDeep = 1;

		TreeNode commonAncestor = null,
				 one = _one, 
				 two = _two;

		while (one.parent != null) {
			one = one.parent;
			oneDeep++;
		}

		while (two.parent != null) {
			two = two.parent;
			twoDeep++;
		}

		one = _one;
		two = _two;

		// now I'm going to calculate the common ancestor (n)

		// first I don't need to check equality
		while (oneDeep > twoDeep) {
			oneDeep--;
			one = one.parent;
		}

		while (twoDeep > oneDeep) {
			twoDeep--;
			two = two.parent;
		}

		// now I need to compare the equality
		while (commonAncestor == null) {
			if (one == two) {
				commonAncestor = one;
			} else {
				one = one.parent;
				two = two.parent;
			}
		}

		return commonAncestor;

	}
}
