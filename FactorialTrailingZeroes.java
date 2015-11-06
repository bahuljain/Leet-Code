//still not working for some reason
public class FactorialTrailingZeroes {
    public int trailingZeroes1(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            int temp = i;
            while(temp % 5 == 0) {
                count++;
                temp = temp/5;
            }
        }
        return count;
    }

    public int trailingZeroes(int n) {
        int count = 0;
        for(int i=5; n/i!=0 ;i*=5){
            count+=n/i;
        }
        return count;
    }
}
