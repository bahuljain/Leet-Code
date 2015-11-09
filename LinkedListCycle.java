public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast = fast.next;
            else return false;

            if(fast == slow) return true;
        }
        return false;
    }
}
