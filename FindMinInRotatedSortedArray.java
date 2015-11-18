public class FindMinInRotatedSortedArray {

        //binary search for the element that is small than both its neighbour

   public int findPeakElement(int[] num, int from, int to) {
         if(to - from == 1) return from;

         int m = (to + from) / 2;

         int l = findPeakElement(num, from, m);
         int r = findPeakElement(num, m, to);

         if(num[l] < num[r]) return l;
         else return r;
   }

   public int findMin(int[] num) {
        return num[findPeakElement(num, 0, num.length)];
   }

}
