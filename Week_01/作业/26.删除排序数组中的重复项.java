/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
//快慢双指针
class Solution {
    public int removeDuplicates(int[] nums) {
        // if(nums == null || nums.length == 0){
        //     return 0;
        // }
        // int i=0;
        // for(int j =0; j<nums.length; ++j){
        //     if(nums[i] != nums[j]){
        //         nums[++i]=nums[j];
        //     }
        // }
        // return i+1;
        //国际站优化写法
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums){
            if (n > nums[i-1]){
                nums[i++] = n;
            } 
        }
        return i;
    }
}
// @lc code=end

