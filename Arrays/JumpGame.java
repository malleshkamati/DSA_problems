package DSA_problems.Arrays;
// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.
public class JumpGame {
    
    public boolean canJump(int[] nums) {
        int maxi=0;
        if(nums.length==1){
            return true;
        }
        
        for(int i=0;i<nums.length-1;i++){

            if(i>maxi){
                return false;
            }
            maxi=Math.max(maxi,nums[i]+i);
            if(maxi>=nums.length-1){
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        
        JumpGame j=new JumpGame();
        System.out.println(j.canJump(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
