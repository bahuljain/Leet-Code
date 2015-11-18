public class PeakElement {

   public int findPeakElement(int[] num, int from, int to) {
         if(to - from == 1) return from;

         int m = (to + from) / 2;

         int l = findPeakElement(num, from, m);
         int r = findPeakElement(num, m, to);

         return (num[l] > num[r]) ? l : r;
   }

   public int findPeakElement(int[] num) {
        return findPeakElement(num, 0, num.length);
   }
}
