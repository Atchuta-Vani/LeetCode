/**
Approach to Solution:
To solve this problem efficiently, we can use a hash map (dictionary) to store the key-value pairs, and for each key, we can store a sorted list of timestamps and corresponding values. This allows us to efficiently find the most recent value that is less than or equal to the requested timestamp.

Steps for Solution:
set(key, value, timestamp):

Use a hash map to store a list of (timestamp, value) pairs for each key.

Append the new (timestamp, value) pair to the list corresponding to the given key.

get(key, timestamp):

Use binary search to efficiently find the largest timestamp that is less than or equal to the given timestamp.

If the key doesn’t exist or no such timestamp exists, return an empty string
 */
//981 Time based key value Store
class TimeMap {

    Map<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<String,List<Pair>>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp,value);
        if(map.containsKey(key)){
            List list = map.get(key);
            list.add(pair);
        }else{            
            List list = new ArrayList();
            list.add(pair);
            map.put(key, list);
        }        
    }
    
    public String get(String key, int timestamp) {
         if(map.containsKey(key)){
            return binarySearch(map.get(key),timestamp);
         }else{
            return "";
         }
    }


    public String binarySearch(List<Pair> list,int timestamp){
        String result = "";            
        if(list == null || timestamp < ((Integer)list.get(0).getKey()).intValue())
            return result; 
        int left = 0;   
        int right = list.size()-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(timestamp == ((Integer)list.get(mid).getKey()).intValue()){
                return (String)list.get(mid).getValue();
            }
            if(timestamp < ((Integer)list.get(mid).getKey()).intValue()){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

    return (String)list.get(right).getValue();        
    }
}



/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
