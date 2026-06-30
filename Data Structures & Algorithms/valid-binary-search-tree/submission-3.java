/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private boolean isValid(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    private boolean inorder(TreeNode root, TreeNode[] prev) {
        if (root == null) return true;
        if (!inorder(root.left, prev)) return false;
        if (prev[0] != null && prev[0].val >= root.val) return false;
        prev[0] = root;
        return inorder(root.right, prev);
    }

    public boolean isValidBST(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        return inorder(root, prev);
        // return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
