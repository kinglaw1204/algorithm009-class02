### 个人感悟& 总结

**1、动态规划**

动态规划本质就是分治，利用分治的思想来解决问题，寻找DP方程最关键，以最长回文串子串为例，思路如下：

特性1：对于一个子串，如果它是回文串，并且长度大于2，那么去掉收尾后它任然是个回文串，比如xyxyx,这里yxy是回文串，那么xyxyx也是回文串。

我们以“xyxyx”字符串来判断回文串，0-4表示字符串的下标。我们用dp[i] [j]来表示 s[i.....j] 是回文串，那么dp[i] [i] 表示自己和自己比是否是回文串，所以肯定是回文串。那么dp [i] [i] 恒为true。

我们用一个表格来描述动态规划

| i: j-> | 0    | 1     | 2     | 3     | 4     |
| ------ | ---- | ----- | ----- | ----- | ----- |
| 0      | True | False | True  | False | True  |
| 1      |      | True  | False | True  | False |
| 2      |      |       | True  | False | True  |
| 3      |      |       |       | True  | False |
| 4      |      |       |       |       | True  |

这里可以知道dp[0] [4] 就是该字符串的最长回文子串。

所以我们可以借助第三方变量来记录是回文子串的位置即可。所以代码如下：

```java
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
                        //状态转移方程,填下一个表格
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
```

**2、作业&[不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)的DP方程**

思路：求到终点有多少解法，那么用格子表示就是dp[i] [j]表示走到该格子有多少走法。

那么状态转移方程就为：dp[i] [j] =dp[i-1,j]+dp[i,j-1]。如果有障碍物就是0，那么dp[i] [j] =0;

所以总的dp方程就是：dp[i] [j] =dp[i-1,j]+dp[i,j-1] or dp[i] [j] =0;

代码如下：

```java
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //边界判断
        if(obstacleGrid== null || obstacleGrid.length ==0){
            return 0;
        }
        //初始化dp数组,第一列和第一行的格子只有一种走法
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0]==0; i++) {
            dp[i][0]=1;
        }

        for (int j = 0; j < n && obstacleGrid[0][j]==0; j++) {
            dp[0][j]=1;
        }

        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
```

