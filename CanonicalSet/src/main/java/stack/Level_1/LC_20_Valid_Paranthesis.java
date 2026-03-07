package stack.Level_1;

import org.junit.Test;

import java.util.Stack;

public class LC_20_Valid_Paranthesis {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(' || c=='[' || c=='{')
                stack.push(c);
            else if(c==')'){
                if(stack.isEmpty() || stack.peek()!='(') return false;
                stack.pop();
            } else if(c=='}'){
                if(stack.isEmpty() || stack.peek()!='{') return false;
                stack.pop();
            } else if(c==']'){
                if(stack.isEmpty() || stack.peek()!='[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void tc(){
        System.out.println(this.isValid("(){}"));
    }
}
