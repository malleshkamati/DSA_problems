package DSA_problems.LinkedList;

public class ReverseLl {
    public static void main(String[] args) {
        ListNode l=new ListNode(1);
        l.next=new ListNode(2);
        l.next.next=new ListNode(3);

        ListNode r=reverseList(l);
        System.out.println(r.val);

    }
    

    public  static ListNode reverseList(ListNode head) {
        
        ListNode prev=null;
        ListNode cur=head;

        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }

        return prev;
    }
}
