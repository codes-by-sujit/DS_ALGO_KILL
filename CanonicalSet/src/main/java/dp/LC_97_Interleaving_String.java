package dp;

public class LC_97_Interleaving_String {
    private Boolean[][] dp;
    private int l1;
    private int l2;
    private int l3;

    public boolean isInterleave(String s1, String s2, String s3) {
        l1=s1.length();
        l2=s2.length();
        l3=s3.length();
        dp=new Boolean[l1+1][l2+1];
        return canForm(s1,s2,s3,0,0);
    }
    private boolean canForm(String s1, String s2, String s3,int i,int j){
        if(i==l1 && j==l2 && i+j==l3) return true;
        if(i+j>=l3) return false;
        if(dp[i][j]!=null) return dp[i][j];

        //Check from S1
        if(i<l1 && s1.charAt(i)==s3.charAt(i+j)){
            dp[i][j] = canForm(s1,s2,s3,i+1,j);
        }
        if(dp[i][j]!=null && dp[i][j]==true) return true;

        //Check from S2
        if(j<l2 && s2.charAt(j)==s3.charAt(i+j)){
            dp[i][j]=canForm(s1,s2,s3,i,j+1);
        }
        return dp[i][j] != null && dp[i][j] == true;
    }

}
