/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    //斐波拉契数列
    public int climbStairs(int n) {
        if (n<=0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int one = 1;
        int two = 2;
        int all = 0;
        for (int i =2 ;i <n; i++){
            all = two + one;
            one = two;
            two = all;
        }
        return all ;
    }
}
// @lc code=end

