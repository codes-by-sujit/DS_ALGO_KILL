package stack.Level_1;

import org.junit.Test;

import java.util.Stack;

public class LC_1047_Remove_Adjacent_Duplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()){
            if(!stack.isEmpty()){
                if(stack.peek()==c) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        if(stack.isEmpty()) return "";
        else{
            String res = "";
            while(!stack.isEmpty()){
                res=stack.pop()+res;
            }
            return res;
        }
    }
    @Test
    public void tc(){
        System.out.println(this.removeDuplicates("azxxzy"));
        System.out.println(this.removeDuplicates("abbaca"));
    }
}
/**
 abbaca
 ca
 */
