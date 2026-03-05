package two_pointer.level1;

import org.junit.Test;

public class LC_680_Valid_Palindrome_II {

    public boolean validPalindrome(String s) {
        return isPalindrome(s,0,s.length()-1,0);
    }

    private boolean isPalindrome(String s, int start, int end,int k){
        if(start>=end) return true;
        if(s.charAt(start)==s.charAt(end))
            return isPalindrome(s,start+1, end-1,k);
        else
            if(k<1) {
                return isPalindrome(s, start + 1, end,k+1) || isPalindrome(s, start, end - 1,k+1);
            } else
                return false;
    }

    @Test
    public void tc(){
        System.out.println(this.validPalindrome("aba"));
        System.out.println(this.validPalindrome("abc"));
        System.out.println(this.validPalindrome("abca"));
    }

/**
    abcecbda

 */
}
