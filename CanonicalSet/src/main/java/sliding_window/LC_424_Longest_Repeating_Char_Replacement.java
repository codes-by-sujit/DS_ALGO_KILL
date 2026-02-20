package sliding_window;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_424_Longest_Repeating_Char_Replacement {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxLen = 0;
        for(;j<s.length();j++){
            //Expand
            Character c=s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq=Math.max(maxFreq,map.get(c));

            //Shrink
            int windowSize = (j-i)+1;
            int charsToDelete = windowSize-maxFreq;
            while(charsToDelete>k){
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar)-1);
                if(map.get(leftChar)==0)
                    map.remove(leftChar);
                i++;
                windowSize = (j-i)+1;
                charsToDelete = windowSize-maxFreq;
            }

            //Validate
            maxLen = Math.max(maxLen, windowSize);
        }
        return maxLen;
    }

    @Test
    public void tc(){
        System.out.println(this.characterReplacement("AABABBA",1));
    }
}
