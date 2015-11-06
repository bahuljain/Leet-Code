public class RomanToInt {
    public int romanToInt(String s) {
        s = s.toUpperCase();

        int sum = val(s.charAt(s.length()-1));
        for(int i = s.length() - 2; i >= 0; i--) {
            if(val(s.charAt(i)) < val(s.charAt(i + 1))){
                sum -= val(s.charAt(i));
            } else {
                sum += val(s.charAt(i));
            }
        }

        return sum;
    }

    public int val(char a) {
        if(a == 'I')
            return 1;
        else if (a == 'V')
            return 5;
        else if (a == 'X')
            return 10;
        else if (a == 'L')
            return 50;
        else if (a == 'C')
            return 100;
        else if (a == 'D')
            return 500;
        else
            return 1000;
    }
}
