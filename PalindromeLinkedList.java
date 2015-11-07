public class PalindromeLinkedList {
    //solving with O(n) space
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack();
        ListNode cur = head;

        while(cur != null) {
            s.push(new Integer(cur.val));
            cur = cur.next;
        }

        cur = head;
        while(cur != null) {
            int x = (int) s.pop();
            if(x != cur.val)
                return false;
            cur = cur.next;
        }

        return true;
    }


    //solving with O(1) space
    public boolean isPalindrome(ListNode head) {
        ListNode m = mid(head);
        m = reverse(m);

        while(m != head && m != null){
            if(m.val != head.val){
                return false;
            }
            m = m.next;
            head = head.next;
        }
        return true;
    }

    ListNode mid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null){
            ListNode t = head.next;

            head.next = prev;
            prev = head;

            head = t;
        }
        return prev;
    }
}
