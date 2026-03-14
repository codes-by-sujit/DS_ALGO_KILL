package greedy.level_3;

import org.junit.Test;

public class LC_1326_Min_Taps_Required {
    public int minTaps(int n, int[] ranges) {
        int[] temp=new int[n+1];

        for(int i=0;i<ranges.length;i++){
           int left = Math.max(0,i-ranges[i]);
           int right = Math.min(n,i+ranges[i]);
           temp[left]=Math.max(temp[left],right);
        }
        return calc(n, temp);
    }

    private int calc(int n, int[] nums){
        int coverage=0;
        int next=0;
        int count=0;
        for(int i=0;i<n;i++){
            coverage=Math.max(coverage,nums[i]);
            if(i==next){
                if(coverage==next) return -1;
                count++;
                next=coverage;
                if(next>=n) return count;
            }
        }

       return -1;
    }

    @Test
    public void tc(){
        System.out.println(this.minTaps(5,new int[] {3,4,1,1,0,0}));
        System.out.println(this.minTaps(3,new int[] {0,0,0,0}));
    }
}
