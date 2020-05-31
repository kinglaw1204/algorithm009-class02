import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    //递归遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderSelf(root,res);
        return res;
    }
    private void inorderSelf(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        if(root.left != null){
            inorderSelf(root.left,res);
        }
        
        res.add(root.val);

        if(root.right != null){
            inorderSelf(root.right, res);
        }
    }
}
// @lc code=end

