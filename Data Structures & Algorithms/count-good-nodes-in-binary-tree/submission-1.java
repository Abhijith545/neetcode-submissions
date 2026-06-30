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
    private int countGoodNodes(TreeNode root, int max) {
        if (root == null) return 0;
        int count = 0;
        if (root.val >= max) {
            max = root.val;
            count += 1;
        }
        count += countGoodNodes(root.left, max);
        count += countGoodNodes(root.right, max);
        return count;
    }

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
}
