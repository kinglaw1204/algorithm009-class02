/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    //双指针 复杂度O(n)
    public void moveZeroes(int[] nums) {
        int i= 0;
        for (int j =0;j <nums.length; ++j){
            if(nums[j]!=0){
                int tmp =nums[j];
                nums[j]=nums[i];
                nums[i++]=tmp;
            }
        }
   }
}
// @lc code=end

