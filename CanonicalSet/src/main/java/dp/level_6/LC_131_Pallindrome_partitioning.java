package dp.level_6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC_131_Pallindrome_partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        solve(s,0,new ArrayList<>(), result);
        return result;
    }

    private void solve(String s, int index, List<String> temp, List<List<String>> result){
        if(index==s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            String curr = s.substring(index,i+1);
            if(isPallindrome(curr)){
                temp.add(curr);
                solve(s,i+1,temp,result);
                temp.removeLast();
            }
        }
    }

    private boolean isPallindrome(String s){
        char[] chars = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(chars[i]!=chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void tc(){
        String s = "aab";
        System.out.println(this.partition(s));
    }
}
