package sliding_window.level3;

import java.util.HashMap;
import java.util.Map;

public class LC_340_Longest_Substring_K_Uniques {
    public int longestKSubstr(String s, int k) {
         int i=0;
         int j=0;
         Map<Character, Integer> map = new HashMap<>();
         int maxLen=-1;
         for(;j<s.length();j++){
             //Expand
             Character c = s.charAt(j);
             map.put(c,map.getOrDefault(c,0)+1);

             //Shrink
             while(map.size()>k){
                 Character left = s.charAt(i);
                 map.put(left,map.get(left)-1);
                 if(map.get(left)==0)
                     map.remove(left);
                 i++;
             }

             //Validate
             if(map.size()==k){
                 maxLen=Math.max(maxLen,(j-i)+1);
             }
         }
         return maxLen;
    }
}
