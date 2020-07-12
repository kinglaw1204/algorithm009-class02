/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    //利用最低位0，n&(n-1)=0
    public int hammingWeight(int n) {
     int count=0;
     while(n!=0){
        count++;
        n&=n-1;
     }
     return count;
    }
}
// @lc code=end

