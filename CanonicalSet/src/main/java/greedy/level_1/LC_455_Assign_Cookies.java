package greedy.level_1;

import org.junit.Test;

import java.util.Arrays;

public class LC_455_Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int max=0;
        int i=0;
        int j=0;
        while(i<g.length && j<s.length){
            int child=g[i];
            int candy=s[j];
            if(child<=candy){
                i++;
                j++;
                max++;
            } else{
                j++;
            }
        }
        return max;
    }

    @Test
    public void tc(){
        int[] g= new int[]{1,2,3};
        int[] s = new int[]{1,1};
        System.out.println(this.findContentChildren(g,s));
    }
    @Test
    public void tc2(){
        int[] g= new int[]{1,2};
        int[] s = new int[]{1,2,3};
        System.out.println(this.findContentChildren(g,s));
    }
}
