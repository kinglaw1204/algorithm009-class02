### 学习笔记

#### 1、基础概念

- 回溯：回溯法（探索与回溯法）是一种选优搜索法，又称为试探法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。

- 递归模板 java

  ```
  // Java
  public void recur(int level, int param) { 
    // terminator 
    if (level > MAX_LEVEL) { 
      // process result 
      return; 
    }
    // process current logic 
    process(level, param); 
    // drill down 
    recur( level: level + 1, newParam); 
    // restore current status 
   
  }
  ```

  

#### 2、实战题目

- [x] [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
- [x] [括号生成](https://leetcode-cn.com/problems/generate-parentheses/) 
- [x] [Pow(x, n) ](https://leetcode-cn.com/problems/powx-n/)

#### 3、本周作业

- [x] [二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- [ ] 从前序与中序遍历序列构造二叉树
- [x] [组合](https://leetcode-cn.com/problems/combinations/)
- [ ] 全排列
- [ ] 全排列2

#### 4、感悟&技巧

 - 递归思维要点
   	- 不要人肉递归（最大误区）
   	- 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
   	- 数学归纳法