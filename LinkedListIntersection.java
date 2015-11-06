/*
Method 1(Simply use two loops) Use 2 nested for loops. Outer loop will be for
each node of the 1st list and inner loop will be for 2nd list. In the inner
loop, check if any of nodes of 2nd list is same as the current node of first
linked list. Time complexity of this method will be O(mn) where m and n are the
number of nodes in two lists.

Method 2 (Mark Visited Nodes) This solution requires modifications to basic
linked list data structure. Have a visited flag with each node. Traverse the
first linked list and keep marking visited nodes. Now traverse second linked
list, If you see a visited node again then there is an intersection point,
return the intersecting node. This solution works in O(m+n) but requires
additional information with each node. A variation of this solution that doesn’t
require modification to basic data structure can be implemented using hash.
Traverse the first linked list and store the addresses of visited nodes in a
hash. Now traverse the second linked list and if you see an address that already
exists in hash then return the intersecting node.

Method 3(Using difference of node counts) 1) Get count of the nodes in first
list, let count be c1. 2) Get count of the nodes in second list, let count be
c2. 3) Get the difference of counts d = abs(c1 – c2) 4) Now traverse the bigger
list from the first node till d nodes so that from here onwards both the lists
have equal no of nodes. 5) Then we can traverse both the lists in parallel till
we come across a common node. (Note that getting a common node is done by
comparing the address of the nodes) Time Complexity: O(m+n) Auxiliary Space:
O(1)

Method 4(Make circle in first list) 1. Traverse the first linked list(count the
elements) and make a circular linked list. (Remember last node so that we can
break the circle later on). 2. Now view the problem as find the loop in the
second linked list. So the problem is solved. 3. Since we already know the
length of the loop(size of first linked list) we can traverse those many number
of nodes in second list, and then start another pointer from the beginning of
second list. we have to traverse until they are equal, and that is the required
intersection point. 4. remove the circle from the linked list.
Time Complexity: O(m+n) Auxiliary Space: O(1)
*/

/*class ListNode {
    int val;
    boolean visited;
    ListNode next;
    ListNode(int x) {
    val = x;
    visited = false;
    next = null;
    }
}*/

//Not working because of explicit new declaration of linkedlist, otherwise
//correct method
public class LinkedListIntersection {
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
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

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        int c1 = 0, c2 = 0;
        ListNode l1 = headA, l2 = headB;
        while(l1 != null) {
            c1++;
            l1 = l1.next;
        }

        while(l2 != null) {
            c2++;
            l2 = l2.next;
        }

        if(c1>c2){
            int diff = c1-c2;
            while(diff-- > 0){
                headA = headA.next;
            }
        } else {
            int diff = c2-c1;
            while(diff-- > 0){
                headB = headB.next;
            }
        }

        while(headA != null) {
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
