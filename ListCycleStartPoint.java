public class ListCycleStartPoint {
    // i was bored so i came up with the stupidest answer but 
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        HashSet<ListNode> h = new HashSet();
        while(cur != null) {
            if(!h.add(cur)) return cur;
            cur = cur.next;
        }

        return null;
    }

    // Method 1
    // We know that Floyd’s Cycle detection algorithm terminates when fast and
    // slow pointers meet at a common point. We also know that this common point
    // is one of the loop nodes (2 or 3 or 4 or 5 in the above diagram). We
    // store the address of this in a pointer variable say ptr2. Then we start
    // from the head of the Linked List and check for nodes one by one if they
    // are reachable from ptr2. When we find a node that is reachable, we know
    // that this node is the starting node of the loop in Linked List and we can
    // get pointer to the previous of this node.

    // Method 2
    // This method is also dependent on Floyd’s Cycle detection algorithm.
    // 1) Detect Loop using Floyd’s Cycle detection algo and get the pointer to
    //    a loop node.
    // 2) Count the number of nodes in loop. Let the count be k.
    // 3) Fix one pointer to the head and another to kth node from head.
    // 4) Move both pointers at the same pace, they will meet at loop starting
    //    node.
    // 5) Get pointer to the last node of loop and make next of it as NULL.

/*    Method 3
      Distance traveled by fast pointer = 2 * (Distance traveled
                                         by slow pointer)

      (m + n*x + k) = 2*(m + n*y + k)

      Note that before meeting the point shown above, fast
      was moving at twice speed.

      x -->  Number of complete cyclic rounds made by
             fast pointer before they meet first time

      y -->  Number of complete cyclic rounds made by
             slow pointer before they meet first time

      From above equation, we can conclude below

          m + k = (x-2y)*n

      Which means m+k is a multiple of n.

      So if we start moving both pointers again at same speed such that one
      pointer (say slow) begins from head node of linked list and other pointer
      (say fast) begins from meeting point. When slow pointer reaches beginning
      of linked list (has made m steps). Fast pointer would have made also moved
      m steps as they are now moving same pace. Since m+k is a multiple of n and
      fast starts from k, they would meet at the beginning. Can they meet before
      also? No because slow pointer enters the cycle first time after m steps.

  */
}
