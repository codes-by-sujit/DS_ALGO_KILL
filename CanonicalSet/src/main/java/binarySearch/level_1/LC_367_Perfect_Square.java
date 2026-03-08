package binarySearch.level_1;

import org.junit.Test;

public class LC_367_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        int n=num/2;
        int i=0;
        int j=n;
        while(i<=j){
            int mid=i+(j-i)/2;
            long mul= (long) mid *mid;
            if(mul==num) return true;
            else if(num>mul)
                i=mid+1;
            else
                j=mid-1;
        }
        return false;
    }

    @Test
    public void tc(){
        System.out.println(this.isPerfectSquare(808201));

    }
}
