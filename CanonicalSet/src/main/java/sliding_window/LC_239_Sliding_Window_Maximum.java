package sliding_window;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class LC_239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[(nums.length-k)+1];
        int i=0;
        int j=0;
        int index=0;
        for(;j<nums.length;j++){
            //Expand
            int curr = nums[j];
            while(!deque.isEmpty() && deque.peekLast()<curr)
                deque.pollLast();
            deque.offerLast(curr);

            //shrink
            if((j-i)+1>k){
                int leftNum=nums[i];
                if(!deque.isEmpty() && deque.peekFirst()==leftNum)
                    deque.pollFirst();
                i++;
            }

            //validate
            if((j-i)+1==k){
                result[index++]=deque.peekFirst();
            }
        }
        return result;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(this.maxSlidingWindow(nums,3));
    }
    @Test
    public void tc2(){
        int[] nums = new int[]{1};
        System.out.println(this.maxSlidingWindow(nums,1));
    }
}
