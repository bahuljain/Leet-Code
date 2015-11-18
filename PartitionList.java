public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        if (head.next == null) return head;

        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        fakeHead.next = head;

        ListNode cur = fakeHead;
        ListNode part = fakeHead;
        while(cur.next != null) {
            if (cur.next.val < x) {
                cur = cur.next;
                part = part.next;
            } else {
                break;
            }
        }

        while(cur.next != null) {
            if(cur.next.val >= x) {
                cur = cur.next;
            } else {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = part.next;
                part.next = tmp;
                part = part.next;
            }
        }

        return fakeHead.next;
    }
}
