package practise.mar.week1;

import java.util.ArrayList;
import java.util.List;

public class LC_684_1 {

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            boolean[] visited = new boolean[graph.length];
            if(isPathExists(graph,visited,u,v))
                return edge;
            else{
                graph[u].add(v);
                graph[v].add(u);
            }
        }
        return edges[0];
    }

    private boolean isPathExists(List<Integer>[] graph, boolean[] visited, int u, int v){
        if(u==v) return true;
        visited[u]=true;
        for(Integer neb: graph[u]){
            if(!visited[neb] && isPathExists(graph,visited,neb,v))
                return true;
        }
        return false;
    }
    /**
    private List<Integer[]> getDirections(int i,int j){
        List<Integer[]> directions = new ArrayList<>();
        Integer[][] coordinates= new Integer[][]{
                {0,1},{0,-1},
                {1,-1},{1,0},{1,1},
                {-1,-1},{-1,0},{-1,-1}
        };
        for(Integer[] cord: coordinates){
            int x=cord[0];
            int y=cord[1];
            if(x+i>=0 && x+i<=n && y+j>=0 && y+j<=n)
                directions.add(cord);
        }
        return directions;
    }
     **/
}
