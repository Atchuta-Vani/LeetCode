/*
380. Insert Delete GetRandom O(1)
Note: get and remove will return in O(1) time using Map. but for Random, list is needed. index based get will be O(1);
"Algorithm
Insert(val)

If val exists in the map, return false.
Append val to the list.
Store its index in the map.
Return true.
Remove(val)

If val does not exist in the map, return false.
Swap val with the last element in the list.
Update the map with the new index.
Remove val from the list and the map.
Return true.
GetRandom()

Pick a random index from the list and return the element."
 */

class RandomizedSet {

    Map<Integer, Integer> map;
    Random rand = new Random();
    List<Integer> list = new ArrayList();

    public RandomizedSet() {
        map = new HashMap();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{           
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
         if(!map.containsKey(val)){
            return false;
        }else{
            int index = map.get(val);
            int lastElement = list.get(list.size()-1);
            list.set(index,lastElement);//put last element of list in index of val.

            map.put(lastElement,index); //  DONOT forget to update index of last element.
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(map.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
