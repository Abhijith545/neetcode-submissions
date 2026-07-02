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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] nodes = data.split(",");
        return build(nodes, new int[1]);
    }

    private TreeNode build(String[] nodes, int[] idx) {
        if ("#".equals(nodes[idx[0]])) {
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx[0]++]));
        root.left = build(nodes, idx);
        root.right = build(nodes, idx);
        return root;
    }
}
