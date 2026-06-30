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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) return rightView;
        Queue<TreeNode> level = new ArrayDeque<>();
        level.offer(root);
        while (!level.isEmpty()) {
            int n = level.size();
            TreeNode curr = null;
            for (int i = 0; i < n; i++) {
                curr = level.poll();
                if (curr.left != null) level.offer(curr.left);
                if (curr.right != null) level.offer(curr.right);
            }
            rightView.add(curr.val);
        }
        return rightView;
    }
}
