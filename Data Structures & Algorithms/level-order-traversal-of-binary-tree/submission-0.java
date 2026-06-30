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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> nodes = new ArrayDeque<>();
        List<List<Integer>> levels = new ArrayList<>();
        nodes.offerLast(root);
        while (!nodes.isEmpty()) {
            int n = nodes.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode curr = nodes.pollFirst();
                if (curr.left != null) nodes.offerLast(curr.left);
                if (curr.right != null) nodes.offerLast(curr.right);
                level.add(curr.val);
            }
            levels.add(level);
        }
        return levels;
    }
}
