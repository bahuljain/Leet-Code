public class Solution {
    // One very simple way would be to convert the linked list to an array, which would be very straightforward but memory inefficient
    // Another way is to traverse to the middle node each time and partition the linked list accordingly.

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        ListNode left = head, middle = getMiddle(head), right = middle.next;
        TreeNode root = new TreeNode(middle.val);

        root.left = (left != middle) ? sortedListToBST(left) : null;
        root.right = sortedListToBST(right);

        return root;
    }

    // returns the middle node of the list.
	public ListNode getMiddle(ListNode head) {
		ListNode slow = head, fast = head, prev = new ListNode(0);
		prev.next = slow;

		while (fast != null) {
			if (fast.next == null)	break;
			fast = fast.next.next;
			slow = slow.next; prev = prev.next;
		}

        // this is main requirement for prev. The link needs to be broken
        // between the left partition and the right partition.
		prev.next = null;
		return slow;
	}
}
