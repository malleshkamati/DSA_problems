package DSA_problems.Arrays;

import java.util.*;

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.
public class Threesum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lst=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int start=i+1;
            int end=nums.length-1;
            while(end>start){
                int temp=nums[i]+nums[start]+nums[end];
                if(temp==0){
                    lst.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    // skip duplicates for end
                    while (start < end && nums[end] == nums[end - 1]) end--;

                    start++;
                    end--;
                    
                }else if(temp<0){
                    start++;
                }else{
                    end--;
                }
            }
        }

        return lst;
    }

    public static void main(String[] args) {
        Threesum t=new Threesum();
        System.out.println(t.threeSum(new int[]{1,8,6,2,5,4,8,3,7,-7,0}));

    }
}
