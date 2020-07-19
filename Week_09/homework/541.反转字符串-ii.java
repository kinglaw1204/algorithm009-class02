/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] charArray =s.toCharArray();
        for (int i = 0; i < charArray.length; i+=2*k) {
            int x =i ,y=Math.min(i+k-1, charArray.length-1);
            while(x<y){
                char tmp =charArray[x];
                charArray[x++]=charArray[y];
                charArray[y--]=tmp;
            }
        }
        return new String(charArray);
    }
}
// @lc code=end

