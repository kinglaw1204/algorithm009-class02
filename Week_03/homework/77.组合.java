import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n<=0||k<=0 || n<k){
            return res;
        }
        helper(n,k,1,new Stack<Integer>());
        return res;
    }

    private void helper (int n, int k, int start,Stack<Integer> pre){
        //terminal
        if(k == pre.size()){
            res.add(new ArrayList<>(pre));
            return ;
        }
        //process
        for(int i = start;i<=n-k+pre.size()+1;++i ){
            pre.add(i);
             //drill down
             helper(n, k, i+1, pre);
            //reverse status
            pre.pop();
        }
       

      
    }
}
// @lc code=end

