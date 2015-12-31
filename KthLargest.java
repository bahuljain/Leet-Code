import java.util.PriorityQueue;

public class KthLargest {
	public int findKthLargest(int[] nums, int k) {
		// randomized selection algorithm
		PriorityQueue<Integer> heap = new PriorityQueue<>(k);

		for (int i = 0; i < nums.length; i++) {
			if (heap.size() < k) {
				heap.add(nums[i]);
			} else {
				if (heap.peek() < nums[i]) {
					heap.poll();
					heap.add(nums[i]);
				}
			}
		}

		System.out.println(heap.peek());
		return heap.peek();
	}
}
