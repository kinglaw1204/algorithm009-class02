/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
// 暴力解法，直接移动，一个一个移动
// class Solution {
//     public void rotate(int[] nums, int k) {
//         int tmp,pre;
//         for (int i=0;i<k;i++){
//             pre = nums[nums.length-1];
//             for(int j=0;j<nums.length;++j){
//                   tmp = nums[j];
//                   nums[j]= pre;
//                   pre =tmp;
//             }
//         }
//     }
// }
//反转
class Solution {
    public void rotate(int[] nums, int k) {
     k %= nums.length;
     reverse(nums,0,nums.length-1);
     reverse(nums, 0, k-1);
     reverse(nums, k, nums.length -1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j){
            int tmp =nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            j--;
            i++;
        }
    }
}
// @lc code=end

