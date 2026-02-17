package sliding_window;

import org.junit.Test;

import java.util.*;

public class LC_438_Find_Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character,Boolean> map = new HashMap<>();
        Map<Character, Integer> tempMap = new HashMap<>();
        int length=p.length();
        for(Character c:p.toCharArray()) {
            map.put(c, true);
            tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
        }
        int i=0;
        int j=0;
        int counter = length;
        for(;j<s.length();j++){
            Character c = s.charAt(j);
            if(map.containsKey(c)) {
                tempMap.put(c, tempMap.getOrDefault(c, 0) - 1);
                if (tempMap.get(c) >= 0)
                    counter--;
            }
            while((j-i)+1>length){
                Character lc=s.charAt(i);
                if(map.containsKey(lc)) {
                    tempMap.put(lc, tempMap.getOrDefault(lc, 0) + 1);
                    if(tempMap.get(lc)>0)
                        counter++;
                }
                i++;
            }

            if(counter==0 && (j-i)+1==length){
                result.add(i);
            }

        }
        return result;
    }

    @Test
    public void tc(){
        String s="cbaebabacd";
        String p="abc";
        System.out.println(this.findAnagrams(s,p));
    }
}
