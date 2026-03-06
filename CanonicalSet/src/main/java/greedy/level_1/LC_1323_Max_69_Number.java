package greedy.level_1;

public class LC_1323_Max_69_Number {
    public int maximum69Number (int num) {
        int i=0;
        int result = 0;
        boolean isChanged=false;
        String s=num+"";
        for(char c:s.toCharArray()){
            if(c=='6' && !isChanged){
                c='9';
                isChanged=true;
            }
            result= result*10+ Integer.parseInt(c+"");
        }
        return result;
    }
}