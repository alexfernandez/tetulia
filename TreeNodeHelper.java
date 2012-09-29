import java.util.Set;
import java.util.HashSet;

public final class TreeNodeHelper {

    public final static TreeNode findCommonAncestor(final TreeNode _one,
                                                    final TreeNode _two) {
        TreeNode result = null,
                one = _one,
                two = _two;

        if (one == two) {
            result = one;
        } else {
            final Set<TreeNode> oneAncestors = new HashSet<TreeNode>();
            final Set<TreeNode> twoAncestors = new HashSet<TreeNode>();

            oneAncestors.add(one);
            twoAncestors.add(two);

            while (result == null) {

                if (one.parent != null) {
                    one = one.parent;
                    if (twoAncestors.contains(one)) {
                        result = one;
                    } else {
                        oneAncestors.add(one);
                    }
                }

                if (result == null && two.parent != null) {
                    two = two.parent;
                    if (oneAncestors.contains(two)) {
                        result = two;
                    } else {
                        twoAncestors.add(two);
                    }
                }

            }
        }

        return result;
    }

}