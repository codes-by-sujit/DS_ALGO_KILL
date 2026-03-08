package binarySearch.level_1;

public class LC_374_Guess_Number_Higher_Lower {
    public int guessNumber(int n) {
        int i=0;
        int j=n;
        while(i<=j){
            int mid=i+(j-i)/2;
            int res=guess(mid);
            if(res==0) return mid;
            else if(res==1) i=mid+1;
            else j=mid-1;
        }
        return -1;
    }
    private int guess(int num){
        return 0;
    }
}
