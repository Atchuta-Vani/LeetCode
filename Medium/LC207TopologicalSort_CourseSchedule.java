/**
create graph (courses List<Set>)
update indegree of pre reqs by +1

add leaves to Queue (one with indegree 0)

create topoOrder List

while q is not empty
dequeue from q, add it to topo
reduce neibors indegree by 1.
if neibhors indegree is 0, add it to Queue.

if topList != graph, there is cycle. return false;

return topoList.

Time Complexity - 

207 Course Schedule
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses == 1){
            return true;
        }

        List<Set<Integer>> adjList = new ArrayList();
        int[] indegree = new int[numCourses];

        for(int i = 0; i< numCourses; i++){
            adjList.add(new HashSet());
            indegree[i] = 0;
        }

        //iterate on edges and add all edges to nodes.
        for(int[] preReq: prerequisites){
            adjList.get(preReq[0]).add(preReq[1]);                                  
        }
        
        //for neighbors, increment inDegree
         for(int j = 0; j< numCourses; j++){
            for(Integer neighbor: adjList.get(j)){
                indegree[neighbor]++;
            }
         }
         

      //  System.out.println("adjList "+adjList);
      //  System.out.println("indegree "+ Arrays.toString(indegree));

        Queue<Integer> leaves = new LinkedList<>();

        for(int i = 0; i< numCourses;i++){
            if(indegree[i] == 0){
                leaves.add(i);
            }
        }

       // System.out.println("leaves "+leaves);
        List<Integer> topoList = new ArrayList();

        while(!leaves.isEmpty()){
            Integer leaf = leaves.poll();
                topoList.add(leaf);
                for(Integer nbr: adjList.get(leaf)){
                        indegree[nbr] =  indegree[nbr]-1;
                        if(indegree[nbr] == 0){
                            leaves.add(nbr);
                        }
                }
        }

        if(topoList.size() != numCourses ){
            //there is a cycle
            return false;
        }
        return true;
        
    }
}
