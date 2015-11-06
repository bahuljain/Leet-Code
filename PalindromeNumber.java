public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int tmp = x;
        int tmp2 = 0;
        while(tmp != 0) {
            tmp2 = tmp2*10 + tmp % 10;
            tmp = tmp / 10;
        }

        if(tmp2 - x == 0 && tmp2 >= 0)
            return true;
        else
            return false;
    }
}
