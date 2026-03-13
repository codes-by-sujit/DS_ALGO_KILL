package stack.Level_2;

import org.junit.Test;

import java.util.Stack;

public class LC_224_Basic_Calculator {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int result=0;
        int sign=1;
        int temp=0;
        for(char c: s.toCharArray()){
            if(c==' ') continue;
            if(c=='+' || c=='-'){
                result+=temp*sign;
                temp=0;
                sign=c=='+'?1:-1;
            } else if(c=='('){
                result+=temp*sign;
                stack.push(result);
                stack.push(sign);
                sign=1;
                result=0;
            } else if(c==')'){
                result+=sign*temp;
                int prevSign=stack.pop();
                int prev=stack.pop();
                result= prev+prevSign*result;
                sign=1;
                temp=0;
            } else{
                temp=temp*10+(c-'0');
            }
        }
        result+=temp*sign;
        return result;
    }
    @Test
    public void tc(){
        //System.out.println(this.calculate("20+ 5"));
        System.out.println(this.calculate("2 - 5"));
       // System.out.println(this.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
