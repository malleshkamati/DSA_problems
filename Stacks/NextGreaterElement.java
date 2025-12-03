package Stacks;
import java.util.Stack;
import java.util.*;
// The next greater element of some element x in an array is the
//  first greater element that is to the right of x in the same array.
// You are given two distinct 0-indexed integer arrays nums1 and nums2, 
// where nums1 is a subset of nums2.
// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] 
// and determine the next greater element of nums2[j] in nums2. If there is no next 
// greater element, then the answer for this query is -1.

// Return an array ans of length nums1.length such that ans[i] is the next greater element as described 
// above.
// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
public class NextGreaterElement {
    public static void main(String[] args) {

        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};
        NextGreaterElement obj=new NextGreaterElement();
       System.out.println( Arrays.toString(obj.nextGreaterElement(nums1, nums2)));
        
    }
     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[nums1.length];
        int[] nges=new int[nums2.length];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i], i);
        }

        for(int i=nums2.length-1;i>=0;i--){

            while(!stk.isEmpty()&&nums2[stk.peek()]<=nums2[i]){
                stk.pop();
            }
            
            nges[i] = stk.isEmpty() ? -1 : nums2[stk.peek()];

            stk.push(i);
        }

        for(int i=0;i<nums1.length;i++){
            ans[i]=nges[map.get(nums1[i])];
        }

        return ans;

    }

}
