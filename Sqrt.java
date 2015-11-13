public class Sqrt {
    public int mySqrt(int x) {
        if(x < 0) return -1;
        if(x == 0) return 0;

        // x/t + t = 2t
        double t = (double)x;
        double tt = 0;
        while( (int)tt - (int)t != 0 ){
            tt = t;
            t = (x/t + t) /2;

        }

        return (int)tt;
    }
}
