public class PowerOfTwo {
    /*public boolean isPowerOfTwo(int n) {
        if((Math.log(n)/Math.log(2)) % 1.0 == 0)
            return true;
        else
            return false;
    }*/

    // dirty way of solving
    public boolean isPowerOfTwo(int n) {
        while(n > 1){
            if(n % 2 != 0)
                return false;
            n = n/2;
        }
        if(n <= 0)
            return false;
        else
            return true;
    }
}
