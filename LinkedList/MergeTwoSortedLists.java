package DSA_problems.LinkedList;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode();
        ListNode ref = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        if (list1 == null) dummy.next = list2;
        if (list2 == null) dummy.next = list1;

        return ref.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();

        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(3);
        a1.next.next = new ListNode(5);

        ListNode b1 = new ListNode(2);
        b1.next = new ListNode(4);
        b1.next.next = new ListNode(6);

        ListNode res1 = obj.mergeTwoLists(a1, b1);
        while (res1 != null) {
            System.out.print(res1.val + " ");
            res1 = res1.next;
        }

        System.out.println();

        ListNode c1 = new ListNode(1);
        c1.next = new ListNode(2);

        ListNode res2 = obj.mergeTwoLists(c1, null);
        while (res2 != null) {
            System.out.print(res2.val + " ");
            res2 = res2.next;
        }
    }
}
