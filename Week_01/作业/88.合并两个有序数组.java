import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    //暴力解法,合并后排序
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     System.arraycopy(nums2, 0, nums1, m, n);
    //     Arrays.sort(nums1);
    // }
    //双指针从后往前比较
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m-1;
        int b = n-1;
        int p = m+n -1;
        //比较放入元素
        while( a>=0 && b>=0){
         nums1[p--]= nums1[a]<nums2[b]?nums2[b--]:nums1[a--];
        }
          // 放入错失的nums2元素
        System.arraycopy(nums2, 0, nums1, 0, b+1);
      
    }
}
// @lc code=end

