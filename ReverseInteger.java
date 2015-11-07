public class ReverseInteger {
    //the only trick here is to remember first then handle the MIN_VALUE and
    //MAX_VALUE cases
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        int sign = (x>=0) ? 1 : -1;
        x = Math.abs(x);
        int rev = 0;
         while(x != 0) {
            if(rev > (Integer.MAX_VALUE - x%10)/10)
                return 0;

            rev = rev*10 + (x % 10);
            x = x/10;
        }
        return rev*sign;
    }
}
