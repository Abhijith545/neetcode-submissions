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
    private int calcMaxSum(TreeNode root, int[] maxSum) {
        if (root == null) return 0;
        int left = Math.max(calcMaxSum(root.left, maxSum), 0);
        int right = Math.max(calcMaxSum(root.right, maxSum), 0);
        maxSum[0] = Math.max(maxSum[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        calcMaxSum(root, maxSum);
        return maxSum[0];
    }
}
