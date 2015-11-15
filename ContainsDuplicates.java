public class ContainsDuplicates {
  
    public boolean containsDuplicate(int[] nums) {
        HashSet h = new HashSet();

        for(int num: nums) {
            if(!h.add(new Integer(num)))
                return true;
        }
        return false;
    }
}
