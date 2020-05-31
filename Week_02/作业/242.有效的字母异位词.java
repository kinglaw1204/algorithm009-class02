/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    //排序解法
    //哈希映射
    public boolean isAnagram(String s, String t) {
    //判断长度是否相等，不相等肯定不是异位词
    if(s.length() != t.length()) return false;
       //构造长度为26的数组
    int[] res = new int[26];
    for(int i=0;i<s.length();++i){
        res[s.charAt(i)-'a']++;
        res[t.charAt(i)-'a']--;
    }
    for (int j = 0; j < res.length; j++) {
        if(res[j]!=0) return false;
    }
    return true;
    }
}
// @lc code=end

