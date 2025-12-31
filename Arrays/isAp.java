package DSA_problems.Arrays;

import java.util.Arrays;

public class isAp {
    

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if(arr.length<2){
            return true;
        }

        int dif=arr[1]-arr[0];


        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]!=dif){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        isAp p=new isAp();
        int[] arr1={1,2,5,4,3};
        int[] arr2={1,2,3,5,5};
        System.out.println(p.canMakeArithmeticProgression(arr1));
        System.out.println(p.canMakeArithmeticProgression(arr2));
    }
}
