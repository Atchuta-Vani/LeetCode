//1797 Design Authentication Manager
/**
"Add HashMap to store tokenId and expiration Time. 
Add timeToLive int variable to hold timeToLive.
generate Method - add key value to hashMap. 
countUnexpiredTokens - iterate on map if entry value is greater currentime, increment count.
renew - if there is token in map and its expiryTime is > currentTime, then update value to current time+timeToLive."

 */
class AuthenticationManager {
    int timeToLive;
    Map<String,Integer> tokensMap;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokensMap = new HashMap();
    }
    
    public void generate(String tokenId, int currentTime) {
        tokensMap.put(tokenId, currentTime+timeToLive);
        
    }
    
    public void renew(String tokenId, int currentTime) {
        if(tokensMap.containsKey(tokenId) && tokensMap.get(tokenId) > currentTime){
            tokensMap.put(tokenId,currentTime+timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for(Map.Entry<String,Integer> e: tokensMap.entrySet()){
            if(e.getValue() > currentTime){
                count++;
            }
        }
    return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
