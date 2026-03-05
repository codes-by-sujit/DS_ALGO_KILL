package two_pointer.level1;

import org.junit.Test;

public class LC_125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        StringBuilder temp = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isAlphabetic(c))
                temp.append(Character.toLowerCase(c));
            else if(Character.isDigit(c))
                temp.append(c);
        }

        int start=0;
        int end=temp.length()-1;
        while(start<end){
            if(temp.charAt(start)==temp.charAt(end)){
                start++;
                end--;
            } else{
                return false;
            }
        }
        return true;
    }

    @Test
    public void tc(){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(this.isPalindrome(s));
         s = "0P";
        System.out.println(this.isPalindrome(s));
    }
}
