package Stacks;
import java.util.Stack;
// Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

 

// Example 1:

// Input: s = "bcabc"
// Output: "abc"
// Example 2:

// Input: s = "cbacdcbc"
// Output: "acdb"
public class RemoveDuplicateLetter {
    
    public static void main(String[] args) {
        
        System.out.println(removeDuplicateLetters("null"));
        System.out.println(removeDuplicateLetters("bcabc"));
    }

    public  static String removeDuplicateLetters(String s) {
        Stack<Character> stk=new Stack<>();
        int[] lastIndex=new int[26];
        boolean[] visited=new boolean[26];

        for(int i=0;i<s.length();i++){

            lastIndex[s.charAt(i)-'a']=i;
            
        }

        for(int i=0;i<s.length();i++){

            char cur=s.charAt(i);

            if(visited[cur-'a']) continue;

            while(!stk.isEmpty()&&i<lastIndex[stk.peek()-'a']&&stk.peek()>cur){
                char ele=stk.pop();
                visited[ele-'a']=false;
            }

            stk.push(cur);
            visited[cur-'a']=true;
        }


        StringBuilder sb=new StringBuilder();

        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();

        return sb.toString();
    }
}
