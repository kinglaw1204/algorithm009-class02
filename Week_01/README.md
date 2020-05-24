## 学习笔记

### 第一周

### 1.基础概念

**数组：** 存储在连续的内存空间、支持下标随机访问。插入及删除操作（除数组尾部）需要进行数据搬移，存储容量满时插入操作需要重新申请更大的连续内存存储并且进行数据搬移。

- 时间复杂度： 插入和删除O(n),查询O(1)

![image-20200522222727445](https://github.com/kinglaw1204/algorithm009-class02/blob/master/Week_01/img/array.png?raw=true)

**链表：**存储要求不用连续的内存空间，只需要通过指针关联即可，单链表只有一个指针指向后继节点，双链表有两个指针，一个指针指向下一个节点，另一个指针指向前一个节点。

- 时间复杂度：插入和删除O(1),查询O(n)。

![image-20200522223032499](https://github.com/kinglaw1204/algorithm009-class02/blob/master/Week_01/img/linklist.png?raw=true)

**跳表：**它对标的是平衡二叉树（AVL Tree）和二分查找，是一种插入/删除/查询都是O(log n)的数据结构，发明于1989年，它最大的优势就是原理简单，容易实现，方便扩展，效率更高。

- 时间复杂度：查询、插入和删除都是O(logn)。

注意：它只能用于元素有序的情况；现实中的跳表会出现跨步的情况，这是由于节点增删导致的。

![image-20200522223402698](https://github.com/kinglaw1204/algorithm009-class02/blob/master/Week_01/img/skiplist.png?raw=true)

 **栈**: 先进后出的容器,添加删除都是O(1)复杂度,查询是O(n)复杂度。

![](https://www.ruanyifeng.com/blogimg/asset/201311/bg2013112901.png)

 **队列:** 先进先出，添加，删除O(1)复杂度,查询是O(n)复杂度。

![](https://imgedu.lagou.com/751754-20190703221534059-2100057457.png)

**双端队列（Deque）：**两端都可以进出的队列，插入和删除都是O(1)复杂度，查询是O(n)复杂度。

![](https://img2018.cnblogs.com/blog/1483773/201811/1483773-20181129211135334-2120920300.png)

**优先级队列（Priority Queue）**:

1、插入操作O(1),

2、取出操作O(logN),按照元素优先级取

3、底层具体实现数据结构多样和复杂：heap，bst，treap



### 2、刷题心得

1.寻找最近点重复性，因为你只能写 if else  for loop。

2.懵逼状态怎么办？考虑暴力情况，先想简单情况。



### 3、做题的思考过程

#### [ 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

快慢双指针的解法非常巧妙，慢指针在初始位置，快指针在初始位置+1，当快慢指针的数字相等时候，快指针+1，目的是去寻找不相等的数字，当发现快指针新数字与慢指针目前的数字不相等的时候，替换掉慢指针+1位置的数字（因为+1位置的数字等于原位置的数字），接着继续判断是否相等，重复这个过程即可，最后是返回i指针的下标+1即可。

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        //快慢双指针
        if ( nums == null || nums.length == 0) return 0;
      	//慢指针
        int i=0;
      	//快指针j
        for (int j=1; j< nums.length;j++){
           //如果相等，快指针j+1，否则慢指针+1，同时替换掉慢指针+1位置的值。
            if (nums[i]!=nums[j]){
               //替换操作
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }
}
```

#### [设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/)

这个题目我自己做出来是用Java的类库，linklist链表实现的，这算偷懒了，后面看到题解中用到了数组实现双端循环链表，说实话看题解有点懵逼，主要就是设置一个数组，然后设置头指针和尾部指针，添加和删除移动指针即可。刚开始看题解时候，我一直不理解插入头部为什么放入数组尾部，其实头部和尾部是有头指针和尾部指针判断的，不在于数组内部的数据。我参考题解写了一遍，`(end + 1) % capacity == start`的设计相当巧妙。

```java
class MyCircularDeque {
     private int capacity;
     private int arr[];
     private int start;
     private int end;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
       //为什么 数组容量+1，为了区分队列为空和队列已满两种情况冲突，如果不+1的话，初始为空的时候start==end，队列满了也是start == end。
        capacity= k+1;
        arr = new int[capacity];
        start=0;
        end =0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
       if(isFull()){
        return false;
       }
       //计算出头部节点的位置。
       start = (start -1 + capacity) % capacity;
       arr[start]=value;
      return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
           }
        //先赋值，在重新算出新的尾部节点的下彪
        arr[end] =value;
        end = (end+1) % capacity;
       return true;

    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        //被设计在数组的开头，所以是 +1
        start = (start+1) % capacity;
        return true;
       
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        end = (end -1 + capacity ) % capacity;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return arr[start];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        //当 end =0 时，防止下标越界
       return arr[(end-1+capacity) %capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return start == end ;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        
        return (end + 1) % capacity == start;
    }
}
```



###  作业 (完成至少2题)

- [x] [删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
- [x] [旋转数组](https://leetcode-cn.com/problems/rotate-array/)
- [x] [合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
- [x] [合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)
- [x] [两数之和](https://leetcode-cn.com/problems/two-sum/)
- [x] [移动零](https://leetcode-cn.com/problems/move-zeroes/)
- [x] [加一](https://leetcode-cn.com/problems/plus-one/)
- [x] [设计循环双端队列](https://leetcode.com/problems/design-circular-deque)
- [ ] [接雨水](https://leetcode.com/problems/trapping-rain-water/)

