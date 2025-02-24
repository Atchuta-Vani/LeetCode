/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*/
//You can also use LinkedHashMap(); remove the first element in LinkedHashMap when the capacity reaches

class LRUCache {
    class Node{
        int key, value;
        Node prev, next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer,Node> map;
    int capacity = 0;
    Node head, tail;//declare it here

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>(); 
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;// this is must
        tail.prev = head;

    }

    public void addNode(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    
    public int get(int key) {        
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            //add node to the front of the head
            addNode(node);
            return node.value;
        }else{
            return -1;
        }

    }
    
    public void put(int key, int value) {
        //print(map);
        Node newNode = new Node(key,value);
        if(map.containsKey(key)){//no need to remove LRU
                Node node = map.get(key);
                node.value = value;
                removeNode(node);
                addNode(node);
        }else{
            if(map.keySet().size() == capacity){//if the cache is already at capacity, remove least used one
                    //remove from tail 
                    Node keyToRemove = tail.prev;
                    removeNode(keyToRemove);
                    map.remove(keyToRemove.key);
            }
            map.put(key,newNode);
            addNode(newNode);
        }

        
    }

    void print(Map<Integer,Node> map){
        for(Map.Entry e: map.entrySet()){
            System.out.println(e.getKey()+ " and " +e.getValue());
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
