import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public static void main(String[] args){
        int[][] islands = {{1,1,0,0},{1,1,0,0},{0,0,1,1},{0,0,1,1}};
        int num = distinctIslands(islands);
        System.out.println(num);
    }
    public static int distinctIslands(int[][] islands){
        Set<String> hashSet =  new HashSet<String>();
        int count = 0;
        int ROWS = islands.length;
        int COLS = islands[0].length;

        for(int i = 0;i< ROWS;i++)
            for(int j =0 ;j< COLS;j++){
                if(islands[i][j] == 1){
                    count++;
                    String path = new String();
                    dfs(islands, i,j,path,"o");
                    hashSet.add(path);
                }
            }
        return hashSet.size();
        }

    private static void dfs(int[][] islands, int i, int j, String path, String dir) {
        int ROWS = islands.length;
        int COLS = islands[0].length;
        if(i<0 || i>=ROWS  || j<0 || j>=COLS || islands[i][j] == 0 ){
            return;
        }
        //System.out.println("i and j are"+i+" "+j);
        islands[i][j] = 0;
        path = path +dir;

        dfs(islands, i-1,j,path,"l");
        dfs(islands, i+1,j,path,"r");
        dfs(islands, i,j-1,path,"u");
        dfs(islands, i,j+1,path,"d");
    }

}
