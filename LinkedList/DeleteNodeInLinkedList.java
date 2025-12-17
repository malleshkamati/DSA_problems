package DSA_problems.LinkedList;

class DeleteNodeInLinkedList {

    public void deleteNode1(ListNode node) {
        ListNode del = node;

        while (del.next != null) {
            del.val = del.next.val;
            del = del.next;
        }
    }

    public void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

        DeleteNodeInLinkedList obj = new DeleteNodeInLinkedList();

        ListNode a = new ListNode(4);
        a.next = new ListNode(5);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(9);

        obj.deleteNode2(a.next);

        ListNode temp = a;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();

        ListNode b = new ListNode(4);
        b.next = new ListNode(5);
        b.next.next = new ListNode(1);
        b.next.next.next = new ListNode(9);

        obj.deleteNode1(b.next);

        ListNode temp2 = b;
        while (temp2 != null) {
            System.out.print(temp2.val + " ");
            temp2 = temp2.next;
        }
    }
}
