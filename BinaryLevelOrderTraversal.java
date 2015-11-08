public class BinaryLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> vals = new ArrayList<>();
        if(root == null) return vals;

        //separator between two different levels;
        final TreeNode END = new TreeNode(0);

        Deque<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(END);

        List<Integer> level = new ArrayList();
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == END) {
                //important to copy since level could change values later on
                vals.add(new ArrayList<Integer>(level));
                level.clear();

                if(!queue.isEmpty()) queue.add(END);
            } else {
                level.add(cur.val);

                if(cur.left != null) queue.addLast(cur.left);
                if(cur.right != null) queue.addLast(cur.right);
            }
        }

        return vals;
    }
}
