package DSA_problems.Arrays;


import java.util.*;
import java.util.HashSet;
public class TwoSum{

    //find the indexes of 2 elements in in numsay whose sum is equals to target

    public static void main(String[] args) {
        
        int[] arr={1,2,3,4,5,5};
        TwoSum t=new TwoSum();
        int[] ans=t.twosumind(arr, 10);

        System.out.println(Arrays.toString(ans));
        
    }

    public int[] twosumind(int[] nums,int target){

        Map<Integer,Integer> mp=new HashMap<>();
        int[] inds=new int[2];

        for(int i=0;i<nums.length;i++){
            mp.put(target-nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            
            if(mp.containsKey(nums[i])&&mp.get(nums[i])!=i){
                inds[0]=i;
                inds[1]=mp.get(nums[i]);
            }
        }

        return inds;
    }
}
