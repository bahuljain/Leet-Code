public class PopulateNextNode {

    // Using O(n) space complexity
    public void connect(TreeLinkNode root) {
        if(root == null) return;

        final TreeLinkNode END = new TreeLinkNode(-1);

        Queue<TreeLinkNode> queue = new LinkedList();
        queue.add(root); queue.add(END);

        while(!queue.isEmpty()) {
            TreeLinkNode cur = queue.remove();

            if(cur == END) {
                if (!queue.isEmpty()) queue.add(END);
                continue;
            }

            if (queue.peek() == END) cur.next = null;
            else cur.next = queue.peek();

            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
    }

    // using O(1) space complexity
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;

        root.left.next = root.right;

        if(root.next == null) root.right.next = null;
        else root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);
    }
}
