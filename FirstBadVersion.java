/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        return search(1,n);
    }

    public int search(int start, int end) {
        if(start == end) {
            if(isBadVersion(start)) return start;
            else return start+1;
        } else {
            int ver = (end + start)/2;
            if(isBadVersion(ver)) return search(start, ver);
            else return search(ver + 1, end);
        }
    }

    // after banging my head over stack overflow tg123 
    public int firstBadVersion(int n) {
        int good = 0;
        int bad = n;

        for(;;) {
            if(bad - good <= 1) return bad;

            int ver = (bad - good)/2 + good;

            if(isBadVersion(ver)) bad = ver;
            else good = ver;
        }

    }
}
