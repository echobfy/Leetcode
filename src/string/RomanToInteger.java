package string;

public class RomanToInteger {
    public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
        	num *= 10;
        	num += s.indexOf(i) - '0';
        }
        return num;
    }
}
