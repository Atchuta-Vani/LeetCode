/**
DFS + Adjacency List
For each account, connect all emails together (undirected graph).

DFS:
For each unvisited email, use DFS to collect all connected emails (a full account).
Sort emails and add name.
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,List<String>> graph = new HashMap();
        Map<String, String> emailToName = new HashMap();

        for(List<String> account: accounts){
            String name = account.get(0);
            for(int i = 1;i<account.size();i++){
                String email = account.get(i);
                emailToName.put(email,name);
                graph.putIfAbsent(email,new ArrayList());

                if(i>1){
                    graph.get(email).add(account.get(i-1));
                    graph.get(account.get(i-1)).add(email);
                }
            }
        }

        List<List<String>> result = new ArrayList();
        Set<String> visited = new HashSet();
        for(String email: graph.keySet()){
            if(!visited.contains(email)){
                List<String> group = new ArrayList();
                dfs(email,graph, group, visited);
                Collections.sort(group);
                group.add(0,emailToName.get(email));
                result.add(group);
            }            
        } 
    return result;

    }

    public void dfs(String email, Map<String,List<String>> graph, List<String> group, Set<String> visited ){
        visited.add(email);
        group.add(email);

        for(String neighbor: graph.get(email)){
            if(!visited.contains(neighbor)){
                dfs(neighbor, graph, group, visited);
            }
        }
    }
}
