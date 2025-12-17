package DSA_problems.LinkedList;
// Given the head of a linked list, remove the nth node from the end of the list and return its head.


public class RemoveNthNode {
    
    public static void main(String[] args) {
        ListNode l=new ListNode(1);
        l.next=new ListNode(2);
        l.next.next=new ListNode(3);
        ListNode result = removeNthFromEnd(l, 1);
while (result != null) {
    System.out.print(result.val + " ");
    result = result.next;
}

    }

    public  static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null||head.next==null){
            return null;
        }

        
        
        ListNode ref=head;
        ListNode slow=head;
        ListNode fast=head;

        for(int i=0;i<n;i++){
            fast=fast.next;
        }

        if(fast==null){
            return head.next;
        }

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        
        
            slow.next=slow.next.next;
            // return ref;
        

        return ref;


    }
}
