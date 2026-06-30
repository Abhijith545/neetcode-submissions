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
    private void countGoodNodes(TreeNode root, int max, int[] totalGoodNodes) {
        if (root == null) return;
        if (root.val >= max) {
            max = root.val;
            totalGoodNodes[0]++;
        }
        countGoodNodes(root.left, max, totalGoodNodes);
        countGoodNodes(root.right, max, totalGoodNodes);
    }

    public int goodNodes(TreeNode root) {
        int[] totalGoodNodes = new int[1];
        countGoodNodes(root, Integer.MIN_VALUE, totalGoodNodes);
        return totalGoodNodes[0];
    }
}
