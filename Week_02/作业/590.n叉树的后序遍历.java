import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.soap.Node;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    //递归，时间复杂度O(n),空间复杂度O(n)
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root ==  null) return res;
        helper(root,res);
        return res;
    
    }
    private void helper(Node node,List<Integer> list){
        if(node == null){
            return ;
        }
        for(Node nn: node.children){
            helper(nn, list);
        }
        list.add(node.val);
    }
}
// @lc code=end

