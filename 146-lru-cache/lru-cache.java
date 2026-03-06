class LRUCache {
    public int capacity;
    public Map<Integer,Node> map;
    public DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new DoublyLinkedList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        dll.moveToFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // if already exist 
        if(map.containsKey(key)){
            Node node = map.get(key);
            dll.moveToFirst(node);
            node.value = value;
            return;
        }
        else{
            Node node = new Node(key,value);
            if(map.size() == capacity){
                Node removed = dll.removeLast();
                map.remove(removed.key);
                dll.addFirst(node);
                map.put(key,node);
            }
            else{
                map.put(key,node);
                dll.addFirst(node);
            }
            return;
        }
    }
}
class Node{
    public int key,value;
    public Node next,prev;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
        this.prev = null; 
        this.next = null;
    }
}

class DoublyLinkedList{
    public int length;
    public Node head,tail;

    public DoublyLinkedList(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public void addFirst(Node node){
        //if empty
        //if head == tail
        //if normal
        if(length == 0){
            head = node;
            tail = node;
        }
        else{
            // - 1 - 
            node.next = head;
            head.prev = node;
            head = node;
        }
        length++;
        return;
    }
    public Node removeLast(){
        if(length == 0){
            return null;
        }
        else if(head == tail){
            Node removed = tail;
            head = null;
            tail = null;
            length--;
            return removed;
        }
        else{
            Node removed = tail;
            tail.prev.next = null;
            tail = tail.prev;
            removed.prev = null;
            length--;
            return removed;
        }
    }
    public void remove(Node node){
        if(length == 0){
            return;
        }
        else if(node == head){
            head = head.next;
            head.prev.next = null;
            head.prev = null;
            length--;
            return;
        }
        else if(node == tail){
            removeLast();
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            length--;
            return;
        }
    }
    public void moveToFirst(Node node){
        if(length == 0){
            return;
        }
        else if(node == head){
            return;
        }
        else if(node == tail){
            removeLast();
            addFirst(node);
            return;
        }
        else{
            node.prev.next = node.next; // make before point to next
            node.next.prev = node.prev; // make next node point to prev
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
            return;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */