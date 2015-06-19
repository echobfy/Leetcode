package hash;

import java.util.HashMap;

public class TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	Integer j = hm.get(target-nums[0]);
        	if (j == null) {
        		hm.put(nums[i], i+1);
        	} else {
        		res[0] = j;
        		res[1] = i + 1;
        		return res;
        	}
        }
        return res;
    }

}
