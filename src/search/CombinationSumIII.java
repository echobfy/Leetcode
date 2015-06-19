package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII {
	
	public static void dfs(List<List<Integer>> ans, Integer[] path, int start, int index, int sum, int n, int k) {
		
		if (index == k) {
			if (sum == n) {
				List<Integer> lst = new ArrayList<Integer>(Arrays.asList(path));
				ans.add(lst);
			}
			return;
		}
		
		for (int i = start + 1; i <= 9; i++) {
			path[index] = i;
			if (sum + i <= n)
				dfs(ans, path, i, index + 1, sum + i, n, k);
		}
	}
	
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		Integer[] path = new Integer[k];
		dfs(ans, path, 0, 0, 0, n, k);
		return ans;
	}
	
	public static void main(String[] args) {
		combinationSum3(3, 9);
	}

}
