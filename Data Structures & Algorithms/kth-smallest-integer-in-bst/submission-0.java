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
    private void inorder(TreeNode root, int k, int[] kthNode) {
        if (root == null) return;
        inorder(root.left, k, kthNode);
        kthNode[0]++;
        if (kthNode[0] == k) kthNode[1] = root.val;
        if (kthNode[1] != -1) return;
        inorder(root.right, k, kthNode);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] kthNode = new int[2];
        kthNode[1] = -1; // to indicate if k th node is visited and avoid extra traversal
        inorder(root, k, kthNode);
        return kthNode[1];
    }
}
