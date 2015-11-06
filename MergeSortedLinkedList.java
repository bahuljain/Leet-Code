/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        merge(l1, l2);
        return l1;
    }

    public void merge(ListNode l1, ListNode l2) {
        while(l2 != null) {
            if(l1.val <= l2.val) {
                if(l1.next == null) {
                    l1.next = l2;
                    break;
                }
                l1 = l1.next;
            } else {
                ListNode node = new ListNode(l1.val);
                node.next = l1.next;
                l1.val = l2.val;
                l1.next = node;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        /*

        */
    }
}
