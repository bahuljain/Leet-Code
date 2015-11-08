public class ReverseBits {
    // lets face it, I could never have come up with this!!! HAHA.. and i have
    // no clue what is going on below. But i will figure it out one fine day

    //you need treat n as an unsigned value
    public static int reverse(int i) {
        // HD, Figure 7-1
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) |
            ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return reverse(n);
    }
}
