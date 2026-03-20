package graph.level_2;

import org.junit.Test;

import java.util.*;


public class LC_752_Open_The_Lock {
    public int openLock(String[] deadends, String target) {
        Map<String,Boolean> deads=new HashMap<>();

        //add the deadends to MAPS for O(1) matching
        for(String d: deadends)
            deads.put(d,true);

        //if 1st set is deadend then return
        if(deads.containsKey("0000")) return -1;

        //Create a queue to hold possible next sets
        Queue<String> queue = new LinkedList<>();

        //Need a visited array to track which set is already visited
        Map<String,Boolean> visited = new HashMap<>();

        //Turn count
        int turn=0;

        queue.offer("0000");
        visited.put("0000",true);

        while(!queue.isEmpty()){
            int size= queue.size();
            for(int i=0;i<size;i++){
                String current=queue.poll();
                if(current.equals(target)) return turn;
                for(String dir:getNeighbours(current)){
                    if(!visited.containsKey(dir) && !deads.containsKey(dir)){
                        visited.put(dir,true);
                        queue.offer(dir);
                    }
                }
            }
            turn++;
        }
        return -1; // all the sets tried but not matched with target
    }

    private List<String> getNeighbours(String s){
        List<String> directions=new ArrayList<String>();
        char[] temp=s.toCharArray();
        for(int i=0;i<temp.length;i++){
            char original=temp[i];
            //forward
            temp[i]= (char) (((original-'0')+1)%10 +'0');
            directions.add(new String(temp));
            //backward
            temp[i]= (char) (((original-'0')+9)%10 + '0');
            directions.add(new String(temp));
            temp[i]=original;
        }
        return directions;
    }

    @Test
    public void tc(){
        String s="1111";
        System.out.println(this.getNeighbours(s));
    }
}
