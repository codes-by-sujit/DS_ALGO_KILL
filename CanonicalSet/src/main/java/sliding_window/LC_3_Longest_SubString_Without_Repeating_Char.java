package sliding_window;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_3_Longest_SubString_Without_Repeating_Char {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int max = Integer.MIN_VALUE;
        for(;j<s.length();j++){
            //Expand
            Character curr = s.charAt(j);
            map.put(curr,map.getOrDefault(curr,0)+1);

            //Shrink
            while(map.get(curr)>1){
                Character leftChar = s.charAt(i);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0)
                    map.remove(leftChar);
                i++;
            }

            //validate
            max = Math.max(max,(j-i)+1);
        }
        return max==Integer.MIN_VALUE?0:max;
    }

    @Test
    public void tc(){
        System.out.println(this.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(this.lengthOfLongestSubstring("bbbb"));
        System.out.println(this.lengthOfLongestSubstring("pwwkew"));
        System.out.println(this.lengthOfLongestSubstring(""));
    }
}
