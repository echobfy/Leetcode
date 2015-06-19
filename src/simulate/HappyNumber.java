package simulate;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	private static Set<Integer> set = null;
	
	public static int getTurndNumber(int n) {
		String str = String.valueOf(n);
		
		int m = 0;
		for (int i = 0; i < str.length(); i++) {
			int k = str.charAt(i) - '0';
			m += k * k;
		}
		return m;
	}
	
    public static boolean isHappy(int n) {
        set = new HashSet<Integer>();
        
        boolean flag = false;
        while (true) {
        	n = getTurndNumber(n);
        	System.out.println(n);
        	if (n == 1) {
        		flag = true;
        		break;
        	} else if (!set.contains(n)) {
        		set.add(n);
        	} else {
        		break;
        	}
        }
        return flag;
    }
    
    public static void main(String[] args) {
    	isHappy(18);
    }
}
