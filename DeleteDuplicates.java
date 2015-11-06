public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        delete(head);
        return head;
    }

    public void delete(ListNode head) {
        while(head != null) {
            while(head.next != null) {
                if(head.val ==  head.next.val) {
                    head.next = head.next.next;
                } else {
                    break;
                }
            }
            head = head.next;
        }
    }
}
