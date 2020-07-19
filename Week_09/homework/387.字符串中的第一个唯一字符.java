/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    //遍历查找第一个出现次数==1的字符
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chars=s.toCharArray();
        for (char c : chars) {
            count[c-'a']++;
        }
        for(int i=0;i<s.length();++i){
            if(count[chars[i]-'a']==1){
                return i;
            }
            
        }
        return -1;
    }
}
// @lc code=end

