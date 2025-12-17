package Stacks;
import java.util.Arrays;
import java.util.Stack;
// Given an array of integers temperatures represents the daily temperatures,
//  return an array answer such that answer[i] is the number of days you have to wait after 
//  the ith day to get a warmer temperature. 
// If there is no future day for which this is possible, keep answer[i] == 0 instead.
public class DailyTemprature {
    
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk=new Stack<>();
        int len=temperatures.length;
        int[] ans=new int[len];

        for(int i=len-1;i>=0;i--){

            while(!stk.isEmpty()&&temperatures[stk.peek()]<=temperatures[i]){
                stk.pop();
            }
            int t=stk.isEmpty()?0:stk.peek()-i;
            ans[i]=t;
            stk.push(i);
        }
        return ans;
    
}
 public static void main(String[] args) {
        DailyTemprature obj = new DailyTemprature();
        int[] result = obj.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(result));
    }
}