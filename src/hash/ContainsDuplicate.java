package hash;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	boolean res;
        	if ((res = set.contains(nums[i])) != false) {
        		return true;
        	}
        	set.add(nums[i]);
        }
        return false;
    }
}
