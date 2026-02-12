package dp;

public class LC_474_Ones_And_Zeros {
    Integer[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new Integer[strs.length][m+1][n+1];
        return get(strs,m,n,0);
    }

    private int get(String[] strs, int m, int n, int index){
        if(index==strs.length) return 0;

        if(dp[index][m][n]!=null) return dp[index][m][n];
        int[] count = getCount(strs[index]);
        int zeroCount = m-count[0];
        int oneCount = n-count[1];
        int skip = get(strs,m,n,index+1);
        int take=0;
        if(zeroCount>=0 && oneCount>=0) {
            take = 1 + get(strs, zeroCount, oneCount, index + 1);
        }
        dp[index][m][n]=Math.max(take,skip);
        return dp[index][m][n];
    }

    private int[] getCount(String s){
        int[] result= new int[2];
        for(char c: s.toCharArray()){
            if(c=='0') result[0]++;
            else result[1]++;
        }
        return result;
    }
}
