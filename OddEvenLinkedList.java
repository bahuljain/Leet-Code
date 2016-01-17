public class Solution {
    public ListNode oddEvenList(ListNode head) {
    	if (head == null || head.next == null) return head;

    	ListNode odd = head, even = head.next, even_head = even;

    	while (even.next != null) {
    		odd.next = even.next;
    		even.next = odd.next.next;

    		odd = odd.next;
    		even = even.next;

    		if (even == null) break;
    	}

    	odd.next = even_head;

    	return head;
    }
}
