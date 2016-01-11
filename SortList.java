public class Solution {
// Simple implementation of merge sort.
	public ListNode sortList(ListNode head) {
		// This line should not be in mergeSort method or else time taken will be
		// more.
		if (head == null) return null;

		return mergeSort(head);
	}

	public ListNode mergeSort(ListNode head) {
		if (head.next == null) return head;

		ListNode left = head; ListNode right = middle(head);
		left = mergeSort(left);
		right = mergeSort(right);

		head = mergeTwoLists(left, right);

		return head;
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

	public ListNode middle(ListNode head) {
		ListNode slow = head, fast = head, middle = new ListNode(0);
		middle.next = slow;

		while (fast != null) {
			if (fast.next == null)
				break;
			fast = fast.next.next;
			slow = slow.next; middle = middle.next;
		}

		middle.next = null;
		return slow;
	}
}
