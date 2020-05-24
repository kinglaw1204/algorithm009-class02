import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    //暴力破解 O(n^2)复杂度
    // public int[] twoSum(int[] nums, int target) {
    //     if (nums == null) {
    //         return null;
    //     }
    //     for(int i=0;i<nums.length-1;++i){
    //         for(int j=i+1; j <nums.length;j++){
    //             if(nums[i]+nums[j]==target){
    //                 return new int[]{i,j};
    //             }
    //         }
    //     }
    //     return new int[]{0,0};

    // }
    //哈希存储 O（n)复杂度
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
             return null;
          }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; ++i){
            if(map.containsKey(target-nums[i])){
                return new int []{map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
// @lc code=end

