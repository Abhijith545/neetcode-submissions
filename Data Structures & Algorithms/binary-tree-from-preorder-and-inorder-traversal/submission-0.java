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
    private TreeNode build(int[] preorder, int[] inorder, int left, int right, int root, Map<Integer, Integer> map) {
        if (left == right) return new TreeNode(inorder[left]);
        int rootVal = preorder[root];
        int i = map.get(rootVal);
        TreeNode leftTree = null, rightTree = null;
        if (i != left) leftTree = build(preorder, inorder, left, i - 1, root + 1, map);
        if (i != right) rightTree = build(preorder, inorder, i + 1, right, root + i - left + 1, map);
        return new TreeNode(rootVal, leftTree, rightTree);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, inorder.length - 1, 0, map);
    }
}
