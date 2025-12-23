package DSA_problems.LinkedList;

import java.util.HashSet;
// cycle detection in LinkedList
public class CycleDetect {
    public static void main(String[] args) {
        CycleDetect c=new CycleDetect();
        ListNode h=new ListNode(0);
        h.next=new ListNode(1);
        h.next.next=new ListNode(2);
        h.next.next.next=new ListNode(3);
        System.out.println(c.isCycle(h));
        System.out.println(c.optimizedIsCycle(h));
        ListNode ref=h.next;
        h.next.next.next=ref;
        System.out.println(c.isCycle(h));
        System.out.println(c.optimizedIsCycle(h));


    }

    boolean isCycle(ListNode head){
        HashSet<ListNode> visited=new HashSet<>();
        while(head!=null){
            if(visited.contains(head)){
                return true;
            }


            visited.add(head);
            head=head.next;
        }

        return false;
    }

    boolean optimizedIsCycle(ListNode head){

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }

        return false;
    }
}
