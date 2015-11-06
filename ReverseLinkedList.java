public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        } else {
            ListNode newHead = new ListNode(head.val);
            while(head.next != null) {
                head = head.next;
                ListNode temp = new ListNode(head.val);
                temp.next = newHead;
                newHead = temp;
            }
            return newHead;
        }
    }
}
