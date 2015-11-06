public class ExcelColumnNumber {
    public int titleToNumber(String s) {
        //65-90
        int sum = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            sum += (s.charAt(i) - 64) * (int)Math.pow(26, s.length() - i - 1);
        }
        return sum;
    }
}
