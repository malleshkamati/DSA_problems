package Stacks;

import java.util.EmptyStackException;

public class Stack {
    
    ListNode head;

    Stack(){
        this.head=null;
    }   
    
    void push(int n){
        ListNode temp=new ListNode(n);
        temp.next=head;
        head=temp;
    }

    int pop(){
        if(head==null){
            throw new EmptyStackException();
        }

        int val=head.val;
        head=head.next;
        return val;
    }

    boolean isEmpty(){
        return head==null;
    }

    int peek(){
        if(head==null){
            throw new EmptyStackException();
        }

        return head.val;
    }
}

