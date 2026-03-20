package sliding_window;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_1358 {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] temp=s.toCharArray();
        int i=0;
        int count=0;
        for(int j=0;j<temp.length;j++){
            //EXPAND
            char curr=temp[j];
            map.put(curr, map.getOrDefault(curr,0)+1);

            //Shrink
            while(map.size()==3){
                count+=temp.length-j;

                char prev=temp[i];
                map.put(prev,map.get(prev)-1);
                if(map.get(prev)==0)
                    map.remove(prev);
                i++;
            }
        }
        return count;
    }

    @Test
    public void tc(){
        String s="abcabc";
        System.out.println(this.numberOfSubstrings(s));
    }
}
