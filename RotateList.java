public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        ListNode cur = head; int length = 1;

        while(cur.next != null) {
            length++;
            cur = cur.next;
        }

        k = k % length;
        if (k == 0) return head;

        cur.next = head; cur = head;
        k = length - k - 1;

        while (k-- > 0) {
            cur = cur.next;
        }

        head = cur.next; cur.next = null;
        return head;
    }
}
