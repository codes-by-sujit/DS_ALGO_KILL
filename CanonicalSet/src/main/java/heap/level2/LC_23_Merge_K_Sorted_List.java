package heap.level2;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC_23_Merge_K_Sorted_List {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        //Add all the heads to pq
        for(ListNode head: lists){
            pq.offer(head);
        }
        if(pq.isEmpty()) return null;

        //prepare the result linkedlist
        ListNode head=null;
        ListNode tail=null;

        while(!pq.isEmpty()){
            ListNode current=pq.poll();
            ListNode temp = new ListNode(current.val);
            if(head==null){
                head=temp;
            } else{
                tail.next=temp;
            }
            tail=temp;
            if(current.next!=null)
                pq.offer(current.next);
        }
        return head;
    }
    
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
