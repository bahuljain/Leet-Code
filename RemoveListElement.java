public class RemoveListElement {
    public ListNode removeElements(ListNode head, int val) {
        // remove all elements from the beginning of the list e.g. [1,1,2,2], 1
        while(head != null) {
            if(head.val == val)
                head = head.next;
            else
                break;
        }

        // handle empty lists. Its important to add this after the previous step for cases like [1,1] , 1 in which after removing elements from the beginning of the list the list becomes empty.
        if(head == null)
            return null;

        // remember the continue, very crucial in cases like [1,2,2,1], 2, basically we not move ahead after deleting a node cause the next node may as well contain a needs-to-be-deleted node
        ListNode cur = head;
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return head;
    }
}
