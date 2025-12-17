package DSA_problems.Stacks;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trapBrute after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented 
by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105*/
public class TrappingRainWater {
     public  static int trapOptimized(int[] height) {
        int ans=0;
        
        int leftmax=0;
        int rightmax=0;
        int left=0;
        int right=height.length-1;

        while(right>left){

            if(height[left]<=height[right]){
                if(height[left]>=leftmax){
                    leftmax=height[left];
                }else{
                    ans+=leftmax-height[left];
                }
                left++;
            }else{
                if(height[right]>=rightmax){
                    rightmax=height[right];
                }else{
                    ans+=rightmax-height[right];
                }
                right--;
            }
        }

        return ans;
    }

    public static int trapBrute(int[] height){
        int ans=0;
        int[] left=new int[height.length];
        int[] right=new int[height.length];

        int lmax=Integer.MIN_VALUE;
        int rmax=Integer.MIN_VALUE;

        for(int i=0;i<height.length;i++){
            lmax=Math.max(lmax,height[i]);
            left[i]=lmax;
        }

        for(int i=height.length-1;i>=0;i--){
            rmax=Math.max(rmax,height[i]);
            right[i]=rmax;
        }

        for(int i=0;i<height.length;i++){
            ans+=Math.min(right[i],left[i])-height[i];
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(trapBrute(new int[]{1}));
        System.out.println(trapBrute(new int[]{1, 2, 3, 4}));
        System.out.println(trapBrute(new int[]{3, 0, 3}));
        System.out.println(trapBrute(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(trapOptimized(new int[]{1}));
        System.out.println(trapOptimized(new int[]{1, 2, 3, 4}));
        System.out.println(trapOptimized(new int[]{3, 0, 3}));
        System.out.println(trapOptimized(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
