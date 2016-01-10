public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0); dummy.next = head;

        ListNode end_prev = head; ListNode end = head.next;

        while(end != null) {
            ListNode prev = dummy; ListNode cur = dummy.next;
            boolean flag = false;

            while(cur != end) {
                if(cur.val > end.val) {
                    prev.next = end; end_prev.next = end.next;
                    end.next = cur; flag = true;
                    break;
                }

                prev = prev.next; cur = cur.next;
            }

            if (flag) { end = end_prev.next; flag = false; }
            else { end_prev = end_prev.next; end = end.next; }
        }

        return dummy.next;
    }
}
