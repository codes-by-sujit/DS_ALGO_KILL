package two_pointer.level1;

import org.junit.Test;

public class LC_11_Container_With_most_Water {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0;
        int j=n-1;
        int water = 0;
        while(i<j){
            int leftHeight = height[i];
            int rightHeight=height[j];

            if(leftHeight==rightHeight){
                water= Math.max(water, (j-i)*leftHeight);
                i++;
                j--;
            } else if(leftHeight>rightHeight){
                water= Math.max(water,(j-i)*rightHeight);
                j--;
            } else{
                water= Math.max(water, (j-i)*leftHeight);
                i++;
            }
        }
        return water;
    }

    @Test
    public void test(){
        System.out.println(this.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}


