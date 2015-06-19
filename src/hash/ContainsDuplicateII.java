package hash;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	Integer res = null;
        	if ((res = map.get(nums[i])) != null) {
        		if (Math.abs(i - res) <= Math.abs(k)) {
        			return true;
        		}
        	}
        	map.put(nums[i], i);
        }
        return false;
    }
}
