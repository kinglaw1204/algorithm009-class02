### 学习笔记

#### 1、基础概念

**动态规划**：将一个复杂的问题分解为一个简单的子问题，也就是分治的思想。

- 动态规划和递归或者分治没有根本上的区别，他们的共性都是寻找重复子问题。动态规划具有最优子结构，中途可以淘汰次优解。
  - 关键点:
    	 - 最优子结构 opt[n]=best_of(opt[n-1],opt[n-2,...])
    	     	 - 存储中间状态：opt[i]
    	     	 - 递推公式（状态转移方程，DP方程）

####  2、实战题目

- [x] 斐波那契数列

- [x] [最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)

- [x] [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

#### 3、课后习题

- [x] [最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
- [x] [回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)

#### 4、个人感想&感悟

动态规划等难点在于寻找DP方程，也就是寻找重复子问题。

以 最小路径和题目为例：给定一个包含非负整数的 *m* x *n* 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。**说明：**每次只能向下或者向右移动一步。由于题目给出要求智能向下或者向右移动，那么对应的就有左边界和上边界。

那么求出最小的路径那么我只要求出向下走和向右走的最小组合即可。每一步都求出向下或者向右的最小值，所以求出DP方程

```
dp[i,j]=grid[i,j]+min(dp[i+1,j],dp[i,j+1])
```

也就是当前点的值加上最小的两种走法最小的值。细化这个dp方程就有四种情况：

1、当i=0,j=0时候，就是当前节点，忽略

2、当i=0,j!=0时候，也就是往右走。

```
dp[i][j]=dp[i][j−1]+grid[i][j] 
```

3、当i!=0,j=0时候，也就是从下走。

```
dp[i][j]=dp[i-1][j]+grid[i][j] 
```

4、当i!=0,j!=0时候,也就是走在中间的时候

```
dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j] 
```

所以整个dp方程就分析出来了，最后就是结合写代码了，转化成代码只有多练才行，自己这块也比较薄弱。

```java
public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
            		//处于当前节点
                if(i == 0 && j == 0) continue;
              	// 向右边走
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
              	//向下走
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
              	//不靠边走情况
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
  			//最后取dp方程的终点结果
        return grid[grid.length - 1][grid[0].length - 1];
    }
```



​		