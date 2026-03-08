package sliding_window.level_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC_239_Sliding_Winow_Max {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int i=0;
        for(int j=0;j<nums.length;j++){
            //Expand
            while(!dq.isEmpty() && dq.peekLast()<nums[j])
                dq.pollLast();
            dq.offerLast(nums[j]);

            //Shrink
            while(j-i>=k){
                int left=nums[i];
                if(dq.peekFirst()==left)
                    dq.pollFirst();
                i++;
            }
            //Validate
            if(j-i==k-1){
                result.add(dq.peekFirst());
            }
        }
        int[] temp=new int[result.size()];
        temp=result.stream().filter(a->a!=null).mapToInt(a->a).toArray();
        return temp;
    }
}
