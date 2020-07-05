import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    private  List<String> res;
    public List<String> generateParenthesis(int n) {
       res = new ArrayList<>();
       helper(0,0,n,"");
       return res;
    }

    private void helper(int left,int right,int n,String s){
        //terminator
        if (n == left && right == n){
            res.add(s);
            return;
        }
        //process
        //剪枝
        if(right>left) return;
        //drill down
        if(left < n){
            helper(left+1, right, n, s+"(");
        }
        if(right < left){
            helper(left, right+1, n, s+")");
        }
       
        //reverse status
    }

}
// @lc code=end

