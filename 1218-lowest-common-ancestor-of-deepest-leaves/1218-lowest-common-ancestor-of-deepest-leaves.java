class Solution {

    private int getHeight(TreeNode root) {
        if (null == root)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    TreeNode lca;

    private boolean traverse(TreeNode root, int depth, int deepest) {
        if (null == root)
            return false;

        boolean leftSide = traverse(root.left, depth + 1, deepest);
        boolean rightSide = traverse(root.right, depth + 1, deepest);

        if (depth == deepest) {
            lca = root;
            return true;
        }
        
        // if both sides are true, this is one of the potential lca node
        if (leftSide && rightSide)
            lca = root;
        
        // but this function should return if from this node we can reach atleast one of the deepest nodes
        return (leftSide || rightSide);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int deepest = getHeight(root);
        lca = null;

        boolean total = traverse(root, 1, deepest);
        
        return lca;
    }
}