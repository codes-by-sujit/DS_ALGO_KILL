package two_pointer.level1;

public class LC_344_Reverse_String {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while(left<right){
            if(s[left]!=s[right]){
                char temp=s[left];
                s[left]=s[right];
                s[right]=temp;
            }
            left++;
            right--;
        }
    }
}
