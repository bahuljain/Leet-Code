public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> empty = new ArrayList();
        result.add(empty);
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList();
            for(List<Integer> list : result) {
                List<Integer> newList = new ArrayList();
                newList.addAll(list);
                newList.add(nums[i]);
                Collections.sort(newList);
                tmp.add(newList);
            }
            result.addAll(tmp);
        }

        return result;
    }
}
