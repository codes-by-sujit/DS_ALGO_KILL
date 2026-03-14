package greedy.level_3;

public class LC_45_Jump_Game {
   public int jump(int[] nums) {
        int steps=0; //Count of steps
        int coverage=0; //Farthest I can go from here
        int next=0; //Where should I jump next;
        int n=nums.length;
        if(n<=1) return 0;
        for(int i=0;i<n;i++){
            coverage=Math.max(coverage,i+nums[i]);
            if(i==next){ //all the points under coverage are parsed
                steps++;
                next=coverage;
                if(next==n-1) break;
            }
         }
        return steps;
    }
}
