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
    private int maxD(TreeNode root) {
        if (root == null) return 0;
        int left = maxD(root.left);
        int right = maxD(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth(TreeNode root) {
        return maxD(root);
    }
}
