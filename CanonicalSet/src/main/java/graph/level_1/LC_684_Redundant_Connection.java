package graph.level_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_684_Redundant_Connection {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<Integer>[] graph=new ArrayList[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            boolean[] visited=new boolean[graph.length];
            if(hasPath(graph,u,v,visited))
                return edge;
            else{
                graph[u].add(v);
                graph[v].add(u);
            }
        }
        return edges[0];
       }

   private boolean hasPath(List<Integer>[] graph,int source, int dest,boolean[] visited){
       if(source==dest) return true; //same node
       visited[source]=true;
       for(int neb:graph[source]){
           if(!visited[neb]){
               if(hasPath(graph,neb,dest,visited))
                   return true;
           }
       }
       return false;
    }

    @Test
    public void tc(){
        int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
        int[] res= this.findRedundantConnection(edges);
        System.out.println(res[0]+","+res[1]);
    }
    @Test
    public void tc2(){
        int[][] edges = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] res= this.findRedundantConnection(edges);
        System.out.println(res[0]+","+res[1]);
    }
}
/**
 tree has n-1 edges and n nodes.
 in this problem edges n-1 and 1 cycling edge given
 total node = n+1
 List<Integer>[] graph[n+1]  => node contains its neighbours
 at any edge check if it's hasPath
    if no then add path to graph
    if yes return that edge
 */
