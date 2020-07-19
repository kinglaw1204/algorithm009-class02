/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    //dp[i][j] 表示s[i...j]是否是回文子串
    public String longestPalindrome(String s) {
        int len =s.length();
        //空串和一个字符都是回文串
        if(len<2){
            return s;
        }
        //定义子串位置
        int begin =0;
        int end = 1;
        //状态转移方程初始化
        boolean [][] dp =new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        char chars[] = s.toCharArray();
        for(int j =1;j<len;j++){
            for(int i =0;i<j;i++){
                //头部和尾部字符不相等，肯定不是回文串
                if(chars[i]!=chars[j]){
                    dp[i][j] =false;
                }else{
                    //头尾相等，判断去掉头尾后是否为回文串
                    if(j-i < 3){
                        dp[i][j] =true;  
                    }else{
                        //状态转移方程
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                 //更新最长子串位置
            if(dp[i][j] && j-i+1 >end){
                end=j-i+1;
                begin =i ;
            }
            }
        }
        return s.substring(begin, begin+end);
    }
}
// @lc code=end

