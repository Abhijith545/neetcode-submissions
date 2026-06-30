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
    private boolean findPath(TreeNode root, TreeNode t, List<TreeNode> path) {
        if (root == null) return false;
        if (root.val == t.val) {
            path.add(root);
            return true;
        }
        if (findPath(root.left, t, path) || findPath(root.right, t, path)) {
            path.add(root);
            return true;
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = new ArrayList<>();
        List<TreeNode> pathToQ = new ArrayList<>();
        findPath(root, p, pathToP); findPath(root, q, pathToQ);
        Collections.reverse(pathToP);
        Collections.reverse(pathToQ);
        TreeNode commonAncestor = root;
        int i = 0;
        while (i < Math.min(pathToP.size(), pathToQ.size()) && pathToP.get(i) == pathToQ.get(i)) {
            commonAncestor = pathToP.get(i);
            i++;
        }
        return commonAncestor;
    }
}
