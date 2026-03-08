package stack.Level_1;

import java.util.ArrayDeque;
import java.util.Deque;


public class LC_225_Stack_using_Queue {
    class MyStack {
        Deque<Integer> dq;
        public MyStack() {
            dq = new ArrayDeque<>();
        }

        public void push(int x) {
            dq.offerLast(x);
        }

        public int pop() {
            if(!dq.isEmpty())
                return dq.pollLast();
            else
                return -1;
        }

        public int top() {
            if(!dq.isEmpty())
                return dq.peekLast();
            else
                return -1;
        }

        public boolean empty() {
            return dq.isEmpty();
        }
    }
}
