package dataStructure;

import java.util.Stack;

public class BasicCalculator {
	
	private static final char[] opChar = {'(', ')', '+', '-', '#', '='};
	private static final char[][] comp = {
		{'<', '=', '<', '<', ' ', ' '},
		{' ', '>', '>', '>', ' ', '>'},
		{'<', '>', '>', '>', ' ', '>'},
		{'<', '>', '>', '>', ' ', '>'},
		{'<', '<', '<', '<', ' ', '='},
		{' ', ' ', ' ', ' ', ' ', ' '},
	};
	
	public static int getIndexOfOpChar(char c) {
		for (int i = 0; i < opChar.length; i++) {
			if (opChar[i] == c) return i;
		}
		return 0;
	}
	
	public static char getCompOfOpChar(char c1, char c2) {
		int n1 = getIndexOfOpChar(c1);
		int n2 = getIndexOfOpChar(c2);
		return comp[n1][n2];
	}
	
	public static int getOpAns(int num1, int num2, char op) {
		int ans = 0;
		switch (op) {
		case '+':
			ans = num1 + num2;
			break;
		case '-':
			ans = num1 - num2;
			break;
		}
		return ans;
	}
	
	public static int getNum(String s, int index) {
		int res = 0;
		for (int i = index; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				res *= 10;
				res += s.charAt(i) - '0';
			} else {
				return res;
			}
		}
		return res;
	}
	
    public static int calculate(String s) {
    	s += '=';
        Stack<Integer> opNumStack = new Stack<Integer>();
        Stack<Character> opCharStack = new Stack<Character>();
        
        opCharStack.push('#');
        int i = 0;
        while (i < s.length()) {
        	char ch = s.charAt(i);
        	if (Character.isDigit(ch)) {
        		int num = getNum(s, i);
        		opNumStack.push(num);
        		while (Character.isDigit(s.charAt(i))) i++;  // What should do in Java?
        		continue;
        	} else if ((ch == '+' || ch == '-' || ch == '(' || ch == ')' || ch == '=') && ch != ' ') {

        		char peakOfStack = opCharStack.peek();
        		char compOfOpChar = getCompOfOpChar(peakOfStack, ch);
        		if (compOfOpChar == '<') {
        			opCharStack.push(ch);
        			i++;
        		} else if (compOfOpChar == '>') {
        			int num2 = opNumStack.pop();
        			int num1 = opNumStack.pop();
        			int res = getOpAns(num1, num2, peakOfStack);
        			opCharStack.pop();
        			opNumStack.push(res);
        		} else if (compOfOpChar == '=') {
        			opCharStack.pop();
        			i++;
        		}
        	} else i++;
        }
        
        return opNumStack.pop();
    }
    
    public static void main(String[] args) {
    	calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
