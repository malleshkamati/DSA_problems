package DSA_problems.LinkedList;

// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        MiddleOfLinkedList obj = new MiddleOfLinkedList();

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        ListNode res1 = obj.middleNode(a);
        while (res1 != null) {
            System.out.print(res1.val + " ");
            res1 = res1.next;
        }

        System.out.println();

        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(3);
        b.next.next.next = new ListNode(4);
        b.next.next.next.next = new ListNode(5);
        b.next.next.next.next.next = new ListNode(6);

        ListNode res2 = obj.middleNode(b);
        while (res2 != null) {
            System.out.print(res2.val + " ");
            res2 = res2.next;
        }
    }
}

