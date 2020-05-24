import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
     private int capacity;
     private int arr[];
     private int start;
     private int end;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
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

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

