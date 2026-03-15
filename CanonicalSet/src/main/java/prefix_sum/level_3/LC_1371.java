package prefix_sum.level_3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_1371 {

    public int findTheLongestSubstring(String s) {
        //array to hold the freq of each vowel
        int[] vowels=new int[5];
        //map to hold the vowel combination pattern
        Map<String, Integer> map = new HashMap<>();
        map.put("00000",-1);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){ //parse all the characters of s
            //check for counts of vowels
            if(s.charAt(i)=='a') vowels[0]=(vowels[0]+1)%2;
            else if(s.charAt(i)=='e') vowels[1]=(vowels[1]+1)%2;
            else if(s.charAt(i)=='i') vowels[2]=(vowels[2]+1)%2;
            else if(s.charAt(i)=='o') vowels[3]=(vowels[3]+1)%2;
            else if(s.charAt(i)=='u') vowels[4]=(vowels[4]+1)%2;

            //Create the combination key from current counts of vowels
            StringBuffer sb= new StringBuffer();
            for(int j: vowels)
                sb.append(j);

            //check if the string is present in map
            if(map.containsKey(sb.toString())){
                int distance=i-map.get(sb.toString());
                max=Math.max(max,distance);
            } else { //update the 1st occurrence of key to map
                map.put(sb.toString(),i);
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }



    @Test
    public void tc(){
        String s="bcbcbc";
        System.out.println(this.findTheLongestSubstring(s));
    }
}

// 01000
