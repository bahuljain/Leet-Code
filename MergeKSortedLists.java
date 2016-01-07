public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	if (lists.length == 0) return null;
    	int n = lists.length;
    	int m = (int) Math.ceil(n/2.0);

    	ListNode[] merged = new ListNode[m];

    	if(n % 2 != 0) merged[m - 1] = lists[n-- - 1];

    	for (int i = 0; i < n; i+=2) {
    		merged[i/2] = mergeTwoLists(lists[i], lists[i+1]);
    	}

    	if(merged.length == 1) return merged[0];
    	return mergeKLists(merged);
    }

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;

        ListNode head = l1;
        while(l2 != null) {
            if(l1.val <= l2.val) {
                if(l1.next == null) {
                    l1.next = l2;
                    break;
                }
                l1 = l1.next;
            } else {
                ListNode node = new ListNode(l1.val);
                node.next = l1.next;
                l1.val = l2.val; l1.next = node;
                l1 = l1.next; l2 = l2.next;
            }
        }
        return head;
    }

    // solution with PriorityQueue / Heap. But as it turns out its slower that
    // previous method. Dont know why!
    public ListNode mergeKListsII(ListNode[] lists) {
        if (lists.length == 0) return null;
    	PriorityQueue<ListNode> heap = new PriorityQueue<>((x1,x2) -> x1.val - x2.val);

    	for(ListNode listHead : lists) {
    		if (listHead != null) heap.offer(listHead);
    	}

    	ListNode dummy = new ListNode(0); ListNode cur = dummy;

    	while(!heap.isEmpty()) {
    		cur.next = heap.poll();
    		cur = cur.next;
    		if (cur.next != null) heap.offer(cur.next);
    	}

    	return dummy.next;
    }
}
