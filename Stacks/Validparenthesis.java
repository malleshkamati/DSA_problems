package Stacks;
// 
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
// determine if the input string is valid.

import java.util.HashMap;
import java.util.Stack;

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
// 
public class Validparenthesis {
    public static void main(String[] args) {
        
        System.out.println(isValid("()))"));
        System.out.println(isValid("()"));
    }
    

    public static boolean isValid(String s) {
        HashMap<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stk=new Stack<>();
        int len=s.length();

        for(int i=0;i<len;i++){

            if(map.containsKey(s.charAt(i))){
                stk.push(s.charAt(i));
            }else{
                if(stk.isEmpty()||map.get(stk.peek())!=s.charAt(i)){
                    return false;
                }
                stk.pop();
            }
        }

        return stk.isEmpty();
    }
    
}
