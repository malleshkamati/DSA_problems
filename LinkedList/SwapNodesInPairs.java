package DSA_problems.LinkedList;


// Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the 
// list's nodes (i.e., only nodes themselves may be changed.)

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {

            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            head = first.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        SwapNodesInPairs obj = new SwapNodesInPairs();

        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);

        ListNode res = obj.swapPairs(l);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
