package DSA_problems.Arrays;
// 11. Container With Most Water

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.
public class WaterContainer {
    public int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int maxwater=0;
        while(end>start){
            maxwater=Math.max(maxwater,Math.min(height[start],height[end])*(end-start));
            if(height[end]>height[start]){
                start++;
            }else{
                end--;
            }
        }   

        return maxwater;
    }

    public static void main(String[] args) {
        
        WaterContainer w=new WaterContainer();
        System.out.println(w.maxArea(new int[]{1,1}));
        System.out.println(w.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        
    }

    
}
