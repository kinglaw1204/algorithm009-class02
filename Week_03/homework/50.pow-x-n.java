/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
     return n >=0 ? helper(x,n) : 1.0/helper(x,-n);
    }

   private double helper(double x, int n) {
       // terminal
       if (n == 0) {
           return 1.0;
       }
       // process

       // dirll down
       double y = helper(x, n / 2);
       return n % 2 == 0 ? y * y : y * y * x;
      //reverse status

    }
}
// @lc code=end

