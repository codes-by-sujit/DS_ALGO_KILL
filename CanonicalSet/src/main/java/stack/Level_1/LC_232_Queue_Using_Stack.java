package stack.Level_1;

import org.junit.Test;

import java.util.Queue;
import java.util.Stack;

public class LC_232_Queue_Using_Stack {
    class MyQueue {
        private Stack<Integer> stack;
        private Integer top=-1;

        public MyQueue() {
            stack=new Stack<>();
        }

        public void push(int x) {
            if(stack.isEmpty())
                top=x;
            stack.push(x);
        }

        public int pop() {
            Stack<Integer> temp=new Stack<>();
            while(!stack.isEmpty())
                temp.push(stack.pop());
            int removed=temp.pop();
            top=temp.isEmpty()?-1:temp.peek();
            while(!temp.isEmpty())
                stack.push(temp.pop());
            return removed;
        }

        public int peek() {
            return top;
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

    @Test
    public void tc(){
        MyQueue q=new MyQueue();
        q.push(1);
        q.pop();
        System.out.println(q.peek());
        System.out.println(q.empty());
    }
}
