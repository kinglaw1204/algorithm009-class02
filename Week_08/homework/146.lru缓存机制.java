import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {
    private HashMap<Integer,Node> map;
    DoubleLinkList cache;
    private int cap;
    public LRUCache(int capacity) {
        this.cap=capacity;
        map = new HashMap<>();
        cache = new DoubleLinkList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int val =map.get(key).val;
        put(key, val);
        return val;
    }
    
    public void put(int key, int value) {

        Node node = new Node(key, value);
        if(map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(node);
            //更新map数据
            map.put(key, node);
        }else{
            //超出容量淘汰最后的节点
            if(cap == cache.size){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(node);
            map.put(key, node);
        }
        
    }


class Node{
    int key, val;
    Node next,pre;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class DoubleLinkList{
    private Node head,tail;
    private int size;
    public DoubleLinkList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.pre=head;
        size =0;
    }
    public void addFirst(Node x){
        x.next=head.next;
        x.pre=head;
        head.next.pre=x;
        head.next=x;
        size++;
    }
    public void remove(Node x){
        if(x == null) return;
        x.pre.next =x.next;
        x.next.pre =x.pre;
        size--;
    }
    public Node removeLast(){
        if(tail.pre==head){
            return null;
        }
        Node last =tail.pre;
        remove(last);
        return last;
    }
    public int size(){
        return size;
    }
}
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

