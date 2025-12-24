package DSA_problems.Arrays;

import java.util.Arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        
        MaxSubArray maxi=new MaxSubArray();

       

        int[] p=maxi.maxSubArrayRange(new int[]{-1,-5,1,2,3,5,6,-10});
        System.out.println(Arrays.toString(p));
    }

    int[] maxSubArrayRange(int[] arr){
        int cur=0;
        int maxi=Integer.MIN_VALUE;
        int[] ans=new int[2];
        int start=0;
        int end=0;
        
        for(int i=0;i<arr.length;i++){
            cur+=arr[i];
            if(cur<arr[i]){
                start=i;
                cur=arr[i];
            }
            if(cur>maxi){
                end=i;
                ans[0]=start;
                ans[1]=end;
                maxi=cur;
            }
        }

        return ans;
    }
}
