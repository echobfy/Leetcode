package sort;

import java.util.Arrays;

public class heapSort {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(nums[nums.length - k]);
        return nums[nums.length - k];
    }
    
    public static void main(String[] args) {
    	findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}
