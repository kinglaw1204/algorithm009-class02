import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.xml.soap.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<Node> stck = new LinkedList<>();
        if(root == null) return res;
        stck.add(root);
        while(!stck.isEmpty()){
            Node node =stck.pollLast();
            res.add(node.val);
            // 把孩子节点反转是为了压栈后是正确顺序取出
            Collections.reverse(node.children); 
            for(Node children:node.children){
                stck.add(children);
            }
        }
        return res;
    }
}
// @lc code=end

