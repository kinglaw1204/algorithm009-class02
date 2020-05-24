/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    //考虑进位的三种情况
    //1、无进位，直接+1
    //2、有进位，中间停止
    //3、有进位，最高位溢出
    // public int[] plusOne(int[] digits) {
    //     for (int i = digits.length-1; i >= 0;i--){
    //         digits[i]++;
    //         digits[i] %=10;
    //         if(digits[i] != 0){
    //             return digits;
    //         }
    //     }
    //     digits= new int [digits.length+1];
    //     digits[0] =1;
    //     return digits;
    // }
    //优化版
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits= new int [digits.length+1];
        digits[0] =1;
        return digits;
    }
}
// @lc code=end

