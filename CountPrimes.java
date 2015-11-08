public class CountingPrimes {
    //BITSET IS FUCKING AMAZING !!!!!! HAWWW
    public int countPrimes(int n) {
        if(n<=2) return 0;

        BitSet checker = new BitSet(n);
        checker.flip(0, n);

        int i = 2;
        for(; i <= Math.sqrt(n); i=checker.nextSetBit(i+1)) {
            for(int j=2; i*j < n; j++) {
                checker.set(i*j, false);
            }
        }
        //excluding 1 and 0
        return checker.cardinality() - 2;
    }
}
