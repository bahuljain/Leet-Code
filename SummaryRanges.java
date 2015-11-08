public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList();
        if(nums.length == 0) return summary;

        int start = -1;
        for(int i = 0;; i++) {
            if(start == -1) start = i;

            // i didnt like this if condition, seems a bit odd, but is an edge
            // case, hence required
            if(i == nums.length - 1) {
                summary.add(createString(nums[start], nums[i]));
                break;
            }

            if(nums[i] + 1 < nums[i+1]) {
                summary.add(createString(nums[start], nums[i]));
                start = -1;
            }
        }
        return summary;
    }

    public String createString(int start, int end){
        if(start == end) return "" + start;
        else return "" + start + "->" + end;
    }


    //this one is crazy, never thought of this
    static class Range {

        int st;
        int ed;

        Range(int st){
            this.st = st;
            this.ed = st;
        }

        public String toString(){
            if(ed == st) return "" + st;

            return st + "->" + ed;
        }
    }

    public List<String> summaryRanges(int[] nums) {

        ArrayList<String> rt = new ArrayList<>();

        if(nums.length == 0) return rt;

        Range r = new Range(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - r.ed == 1){
                r.ed = nums[i];
            } else {
                rt.add(r.toString());
                r = new Range(nums[i]);
            }
        }

        rt.add(r.toString());

        return rt;
    }

}
