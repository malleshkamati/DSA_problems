package DSA_problems.LinkedList;
// You are given two non-empty linked lists representing two non-negative integers.
//  The digits are stored in reverse order, and each of their nodes contains a single digit. 
//  Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
public class AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // if(l1==null){
        //     return l2;
        // }
        // if(l2==null){
        //     return l1;
        // }
       
        ListNode node=new ListNode();
        ListNode ans=node;
        int carry=0;

        while(l1!=null||l2!=null){
            int sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=carry;
            carry=sum/10;
            sum=sum%10;
            node.next=new ListNode(sum);
            node=node.next;
        }
        if(carry==1){
            node.next=new ListNode(1);
            node=node.next;
        }
        return ans.next;
    }
    public static void main(String[] args) {
        AddTwoNums obj = new AddTwoNums();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res1 = obj.addTwoNumbers(l1, l2);
        while (res1 != null) {
            System.out.print(res1.val + " ");
            res1 = res1.next;
        }

        System.out.println();

        ListNode a1 = new ListNode(9);
        a1.next = new ListNode(9);

        ListNode a2 = new ListNode(1);

        ListNode res2 = obj.addTwoNumbers(a1, a2);
        while (res2 != null) {
            System.out.print(res2.val + " ");
            res2 = res2.next;
        }
    }
}
