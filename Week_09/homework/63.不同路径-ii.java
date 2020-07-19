/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    //dp方程定义dp[i][j]表示格子的走法
    //dp[i][j] =dp[i-1,j]+dp[i,j-1];
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
}
// @lc code=end

