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
    int max;
    public int maxDepth(TreeNode root) {
        max = 0;
        return depth(root);
    }
    public int depth(TreeNode root){
        if(root==null) return 0;      
        else return max = 1 + Math.max(depth(root.left), depth(root.right));
    }
}