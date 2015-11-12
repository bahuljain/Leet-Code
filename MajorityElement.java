public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap h = new HashMap(nums.length);
        for(int i = 0; i < nums.length; i++) {
            h.put(new Integer(nums[i]), 0);
        }

        for(int i = 0; i < nums.length; i++) {
            h.put(new Integer(nums[i]), (int)h.get(new Integer(nums[i])) + 1);
        }

        for(int i = 0; i < nums.length; i++) {
            if((int)h.get(new Integer(nums[i])) > nums.length/2) {
                return nums[i];
            }
        }
        return -1;

    }

    // that's the correct answer, mine is a dumb shit answer.
    public int majorityElement(int[] num) {
        int m = num[0];
        int c = 1;

        for(int i = 1; i < num.length; i++){
            if (num[i] == m) {
                c++;
            } else if (c > 1) {
                c--;
            } else { // c == 1 && num[i] != m
                m = num[i];
            }
        }

        return m;
    }

    // using streams... another interesting solution
    public int majorityElement(int[] nums) {
        Map<Integer, List<Integer>> m = IntStream.of(nums).boxed()
                .collect(Collectors.groupingBy((i)->i));

        for (Map.Entry<Integer,List<Integer>> entry : m.entrySet()) {
            if(entry.getValue().size() > nums.length/2)
                return entry.getKey();
        }

        return -1;
    }
}
