### 学习笔记

#### 基础概念

**1、字典树（Trie）**

又称为单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。

优点：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

基本性质：

- 结点本身不存完整单词
- 从根结点到某一个结点，路径上经过的字符连接起来，为该结点对应的字符串
- 每个结点的所有子结点路径代表的字符都不相同

核心思想: 空间换时间

**2、剪枝**

​		剪掉不需要的计算，

**3、双向BFS**

​		从两端进行BFS搜索。

**4、启发式搜索**	

​		模板

```python

def AstarSearch(graph, start, end):
	pq = collections.priority_queue() # 优先级 —> 估价函数
	pq.append([start]) 
	visited.add(start)
	while pq: 
		node = pq.pop() # can we add more intelligence here ?
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
   unvisited = [node for node in nodes if node not in visited]
		pq.push(unvisited)

```

​	启发式函数

​	h(n),它用来评价哪些结点最有希望的是一个我们要找的结点，h(n)会返回一个非负数，也可以认为是从结点n的目标结点路径的估计成本。

​	启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。	 

**5、红黑树**

​	红黑树是一个近似平衡二叉树，

​	性质：

​		1、节点是红色或黑色。

​		2、根是黑色。

​		3、所有叶子都是黑色（叶子是NIL节点）。

​		4、每个红色节点必须有两个黑色的子节点。（从每个叶子到根的所有路径上不能有两个连续的红色节点。）

​		5、从任一节点到其每个叶子的所有[简单路径](https://zh.wikipedia.org/wiki/道路_(图论))都包含相同数目的黑色节点。

**6、AVL**

​	在AVL树中，任一节点对应的两棵子树的最大高度差为1，因此它也被称为**高度平衡树**。查找、插入和删除在平均和最坏情况下的[时间复杂度](https://zh.wikipedia.org/wiki/时间复杂度)都是O(log n)。增加和删除元素的操作则可能需要借由一次或多次[树旋转](https://zh.wikipedia.org/wiki/树旋转)

#### 实战题目

#### 课后习题

- [x] [实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)
- [x] [括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

#### 个人感悟&思考

今天再做一遍括号生成，对于剪枝的理解又深刻了，上次是学递归的时候做的题目，没有引入剪枝的概念，只知道右边括号的生成是依赖左边括号的，所以，当右边括号的的数量大于左边括的时候，直接退出，避免计算，这就是剪枝，剪去肯定不符合条件的路径。

