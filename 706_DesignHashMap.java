//706 Design HashMap
/*
Approach 1: Separate Chaining using Buckets (LinkedLists or ArrayLists)
We implement:

A fixed-size array (say, size = 10,000)

Each index stores a list of (key, value) pairs

We use a simple hash function: key % size
Time Complexity (Average Case)
Operation	Time
put	O(1)
get	O(1)
remove	O(1) 

*/
class MyHashMap {

    class Node{
        int key;
        int value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    List<Node>[] buckets;
    int SIZE = 10000;
    
    public MyHashMap() {
        buckets = new List[SIZE];
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(buckets[index] == null){
            buckets[index] = new LinkedList<Node>();
        }
        for(Node node: buckets[index]){
            if(node.key == key){
                node.value = value;
                return;
            }            
        }
        buckets[index].add(new Node(key, value));
        
    }
    
    public int get(int key) {
        int index = hash(key);
        if(buckets[index] == null)
            return -1;
        for(Node node: buckets[index]){
            if(node.key == key){
                return node.value;
            }
        }         
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(buckets[index] == null){
            return;
        } 
        Iterator<Node> iterator = buckets[index].iterator();
        while(iterator.hasNext()){
            if(iterator.next().key == key){
                iterator.remove();
                return;
            }
        }
        
    }

    public int hash(int key){
        return key%SIZE;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
