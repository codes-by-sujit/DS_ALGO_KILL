package greedy.special;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TeamFormation {
    int n;
    public int maxTeamSize(int[] lowerSkill, int[] higherSkill) {
        n=lowerSkill.length;
        for(int i=n;i>=1;i--){
            if(canForm(i,lowerSkill,higherSkill)) return i;
        }
        return 0;
    }

    private boolean canForm(int k, int[] lowerSkills, int[] higherSkills){
        //Calculate intervals
        List<int[]> intervals=new ArrayList<>();
        for(int i=0;i<n;i++){ //interval for all developers. as we are going to check combination of k best developer from n total developers
            int left = Math.max(0, k-1-higherSkills[i]);
            int right=Math.min(lowerSkills[i],k-1);
            if(left<=right)
                intervals.add(new int[]{left,right});
        }
        if(intervals.size()<k) return false;

        //Sort the intervals
        intervals.sort(Comparator.comparingInt(a -> a[0]));

        //Range fot check
        int index=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int pos=0;pos<k;pos++){
            while(index<intervals.size() && intervals.get(index)[0]<=pos){
                pq.offer(intervals.get(index)[1]);
                index++;
            }
            if(pq.isEmpty()) return false;
            int right=pq.poll();
            if(pos>right) return false;
        }
        return true;
    }

}

/**
 at any team of size k
 lowerskilleddevs + dev_himself + higherskills_dev

 low+1+high=k
 low=k-1-high
 high=k-1-low

 high<=high[i]
 k-1-low<=high[i]
 k-1-high[i]<=low

 we know low<=low[i] rightside
 low>=k-1-high[i]  leftside

 so the dev should stand between L & R
 how many devs? we have 0,1...k-1 dev
 */