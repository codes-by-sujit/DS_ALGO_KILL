package prefix_sum.level_1;

import org.junit.Test;

public class LC_303_Range_Sum_Query {
    class NumArray {
        int[] ps;
        public NumArray(int[] nums) {
            ps = new int[nums.length+1];
            ps[0]=nums[0];
            for (int i=1;i<nums.length;i++)
                ps[i]=ps[i-1]+nums[i];
        }

        public int sumRange(int left, int right) {
            if(left==0) return ps[right];
            else return ps[right]-ps[left-1];
        }
    }

    @Test
    public void tc(){
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));
    }
}

/**
  0  1  2   3  4   5
 -2, 0, 3, -5, 2, -1
 -2,-2, 1, -4, -2, -3

 */
