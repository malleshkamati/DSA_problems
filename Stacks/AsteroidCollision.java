package Stacks;
import java.util.Arrays;
import java.util.Stack;
// We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.

// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same 
// direction will never meet.

public class AsteroidCollision {
    
    
     public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk=new Stack<>();

        for(int a:asteroids){
            boolean isalive=true;
            while(!stk.isEmpty()&&a<0&&stk.peek()>0){
                if(stk.peek()==-a){
                    stk.pop();
                    isalive=false;
                    break;
                }else if(stk.peek()<-a){
                    stk.pop();
                }else{
                    isalive=false;
                    break;
                }
            }
            if(isalive){
                stk.push(a);
            }
        }
        int[] ans=new int[stk.size()];
        int pt=stk.size()-1;
        while(!stk.isEmpty()){
            ans[pt]=stk.pop();
            pt--;
        }

        return ans;
    }

    public static void main(String[] args) {
        AsteroidCollision obj = new AsteroidCollision();

        System.out.println(Arrays.toString(obj.asteroidCollision(
                new int[]{5, 10, -5}
        )));

        System.out.println(Arrays.toString(obj.asteroidCollision(
                new int[]{8, -8}
        )));

        System.out.println(Arrays.toString(obj.asteroidCollision(
                new int[]{10, 2, -5}
        )));
    }
}
