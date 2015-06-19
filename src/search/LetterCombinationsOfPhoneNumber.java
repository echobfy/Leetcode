package search;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	
	public static final String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
    	List<String> ans = new ArrayList<String>();
    	if (digits.equals("") || digits == null)  { // String equals not ==
    		return ans;
    	}
    	
    	char[] path = new char[digits.length()];
    	dfs(digits, ans, path, 0);
    	
    	return ans;
    }
    
    public static void dfs(String digits, List<String> ans, char[] path, int index) {
    	if (index >= digits.length()) {
    		ans.add(new String(path));
    		return;
    	}
    	
    	int number = digits.charAt(index) - '0';
    	for (int i = 0; i < mapping[number].length(); i++) {
    		path[index] = mapping[number].charAt(i);
    		dfs(digits, ans, path, index + 1);
    	}
    }
    
    public static void main(String[] args) {
    	System.out.println(letterCombinations(""));
    }
}
