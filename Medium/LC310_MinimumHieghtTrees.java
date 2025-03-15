/**
LC 310 Minimum Hieght Trees
Topological Sort. 
Key Idea: Layered Removal of Leaves
This is a type of topological sorting where you iteratively remove the outermost layer (leaves) of the tree. The remaining nodes are the center(s).
Time Complexity: O(n)
 */

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //edge case if there is only one node.
        if(n == 1){
            return List.of(0);
        }

        List<HashSet<Integer>> nodes = new ArrayList(n);
        
        //place holder for neighbors
        for(int i = 0; i<n;i++){
            nodes.add(new HashSet<Integer>());
        }
        
        //iterate on edges and add all edgesto nodes.
        for(int[] edge: edges){
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }
        //System.out.println(" Initial nodes "+nodes);

        //get all leaves from nodes
        /* List<Integer> leaves = new ArrayList<Integer>();
        int index = 0;
        for(Set<Integer> node:nodes){
            if(node.size() == 1){
                leaves.add(index);
            }
            index++;
        }
        
        //System.out.println(" leaves "+leaves);
        
        //iterate on leaves and remove them, make new leaves list
        //this is taking lot of time.
       while(n>2){
            n = n- leaves.size();
            Set<Integer> newLeaves = new HashSet();
            for(Integer leaf: leaves){

                Integer edge = nodes.get(leaf).iterator().next();  
                //System.out.println("edge " +edge+" leaf "+leaf);                            

                nodes.get(edge).remove(leaf);
                nodes.remove(leaf);
                if(nodes.get(edge).size() == 1){
                    newLeaves.add(edge);                    
                }
            //System.out.println(" nodes "+nodes);             

                
            }

            //System.out.println(" leaves "+leaves);             

            leaves = new ArrayList(newLeaves);
        }*/

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (nodes.get(i).size() == 1) {
                leaves.add(i);
            }
        }

         // Trim the leaves layer by layer
        while (n > 2) {
            n -= leaves.size();  // Reduce the size of the graph by the number of leaves
            int size = leaves.size();
            
            // Remove leaves and update the adjacency list
            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();  // Get a leaf

                // Get its only neighbor (since it's a leaf, it has only one neighbor)
                int neighbor = nodes.get(leaf).iterator().next();
                
                // Remove the leaf from the neighbor's adjacency list
                nodes.get(neighbor).remove(leaf);
                //System.out.println("nodes "+nodes);
                // If the neighbor has become a leaf, add it to the leaves queue
                if (nodes.get(neighbor).size() == 1) {
                    leaves.add(neighbor);
                }
            }
        }

        return new ArrayList(leaves);
    }
}
