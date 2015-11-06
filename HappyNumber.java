public class HappyNumbers {
    public boolean isHappy(int n) {
        int temp = n;
        do {
            int sum = 0;
            while(n != 0) {
                sum += (int)Math.pow(n % 10, 2);
                n = n / 10;
            }
            if(sum == 1)
                return true;
            n = sum;
        } while (n!=4);
        return false;
    }

    //2,3,4,5,6,8,9
}
