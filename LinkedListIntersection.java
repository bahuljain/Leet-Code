class ListNode {
    int val;
    boolean visited;
    ListNode next;
    ListNode(int x) {
    val = x;
    visited = false;
    next = null;
    }
}

//Still not working for some reason
public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        while(headA != null) {
            headA.visited = true;
            headA = headA.next;
        }

        while(headB != null) {
            if(headB.visited)
                return headB;
            headB = headB.next;
        }
        return null;
    }
}
