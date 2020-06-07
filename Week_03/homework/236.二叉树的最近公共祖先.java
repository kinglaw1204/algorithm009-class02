import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     // terminate
    if(root == null | root == p|| root == q){
        return root;
     }
     //process
     
     // drill down
     TreeNode left = lowestCommonAncestor(root.left,p,q);
     TreeNode right = lowestCommonAncestor(root.right,p,q);
    
     if(left == null){
         return right;
     }
     if(right == null){
         return left;
     }
     return root;
      // reverse status
    }
}
// @lc code=end

