import java.util.Map.Entry;

public class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer,Long> m = Arrays
				.stream(nums)
				.boxed()
				.collect(Collectors.groupingBy(s-> s, Collectors.counting()));

		ArrayList<Integer> result = new ArrayList();

		for (Entry<Integer,Long> entry : m.entrySet()) {
			if(entry.getValue()==1)
				result.add(entry.getKey());
		}

		return result.stream().mapToInt(i->i).toArray();
    }
}
