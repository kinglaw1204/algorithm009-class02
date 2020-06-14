## 第四周学习笔记

### 基础概念

**1、贪心算法**

- 贪心算法：贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。
- 与动态规划的区别：贪心算法对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。
- 场景：解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题，贪心算法一般不能得到我们所要求的答案。简单的说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。
- 补充1：一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。
- 补充2:贪心算法需要考虑贪心的角度，可以从后往前贪心，也可以从局部一个点去贪心。

**2、二分查找法**

- 二分查找前提：
  - 目标函数单调性
  - 存在上下界
  - 能够通过索引访问

### 实战题目

- [x] [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description)
- [ ] [最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description)
- [x] [括号生成](https://leetcode-cn.com/problems/generate-parentheses/#/description)
- [ ] [在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description)
- [ ] [x 的平方根](https://leetcode-cn.com/problems/sqrtx/)
- [ ] [有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/)

### 课后作业

- [x] [柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/description/)
- [x] [买卖股票的最佳时机 II ](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/)
- [ ] [分发饼干](https://leetcode-cn.com/problems/assign-cookies/description/)
- [ ] [模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/description/)
- [ ] [单词接龙](https://leetcode-cn.com/problems/word-ladder/description/)
- [ ] [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
- [ ] [扫雷游戏](https://leetcode-cn.com/problems/minesweeper/description/)
- [ ] [跳跃游戏](https://leetcode-cn.com/problems/jump-game/) 
- [x] [搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
- [ ] [搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)
- [ ] [寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)
- [ ] [单词接龙 II ](https://leetcode-cn.com/problems/word-ladder-ii/description/)
- [ ] [跳跃游戏 II ](https://leetcode-cn.com/problems/jump-game-ii/)
- [ ] 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

### 本周感悟心得

​	1、贪心算法是一种思想，算局部最优解。

​    2、二分法的前提条件一定是要有序并且是有界

​    3、刷题的模板一定要熟练，知道考点后就能写出模板，最后填写内容即可。

### 其他

二分查找模板

```
# Python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

