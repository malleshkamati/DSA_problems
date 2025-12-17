package DSA_problems.LinkedList;


import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        ListNode ans = dummy;

        for (ListNode l : lists) {
            if (l != null) {
                pq.offer(l);
            }
        }

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            dummy.next = temp;
            dummy = dummy.next;
            if (temp.next != null) {
                pq.offer(temp.next);
            }
        }

        return ans.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists obj = new MergeKSortedLists();

        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(4);
        a1.next.next = new ListNode(5);
        ListNode b1 = new ListNode(1);
        b1.next = new ListNode(3);
        b1.next.next = new ListNode(4);
        ListNode c1 = new ListNode(2);
        c1.next = new ListNode(6);
        ListNode[] lists1 = {a1, b1, c1};
        ListNode res1 = obj.mergeKLists(lists1);
        while (res1 != null) {
            System.out.print(res1.val + " ");
            res1 = res1.next;
        }
        System.out.println();

        ListNode[] lists2 = {};

        ListNode res2 = obj.mergeKLists(lists2);
        while (res2 != null) {
            System.out.print(res2.val + " ");
            res2 = res2.next;
        }
    }
}
