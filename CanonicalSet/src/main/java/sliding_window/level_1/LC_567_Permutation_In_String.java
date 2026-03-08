package sliding_window.level_1;

import org.junit.Test;

import java.util.*;

public class LC_567_Permutation_In_String {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> reqMap=new HashMap<>();
        for(Character c: s1.toCharArray()){
            reqMap.put(c, reqMap.getOrDefault(c,0)+1);
        }
        int wordCount=0;
        int i=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int j=0;j<s2.length();j++){
            //include
            Character curr=s2.charAt(j);
            if(reqMap.containsKey(curr)){
                map.put(curr,map.getOrDefault(curr,0)+1);
                if(map.get(curr)<=reqMap.get(curr))
                    wordCount++;
            }
            //shrink
            while(j-i>=s1.length()){
                Character left=s2.charAt(i);
                if(reqMap.containsKey(left)){
                    map.put(left,map.get(left)-1);
                    if(map.get(left)<reqMap.get(left))
                        wordCount--;
                }
                i++;
            }
            //validate
            if(j-i==s1.length()-1 && wordCount==s1.length())
                return true;
        }
        return false;
    }
    @Test
    public void tc(){
        System.out.println(this.checkInclusion("ab","eidbaooo"));
    }
}

