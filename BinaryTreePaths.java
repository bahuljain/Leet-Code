public class BinaryTreePaths {
    //the following two methods combined are the suckiest way of solving this
    //problem and should not be referred to. This was what i came up with!! lOL
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        if(root == null)
            return list;
        String path = "" + root.val;
        List<String> left = paths(root.left, path);
        List<String> right = paths(root.right, path);

        left.removeAll(right);
        left.addAll(right);
        if(left.size() > 1 && left.contains(path)){
            left.remove(path);
        }
        return left;
    }

    public List<String> paths(TreeNode root, String path) {
        if(root == null) {
            List<String> list = new ArrayList();
            if(path.length()>0)
                list.add(path);
            return list;
        }

        path = path + "->" + root.val;
        List<String> left = paths(root.left, path);
        List<String> right = paths(root.right, path);

        left.removeAll(right);
        left.addAll(right);
        if(left.size() > 1 && left.contains(path)){
            left.remove(path);
        }
        return left;
    }

    //here's the beautiful awesome solution to this problem (LEARN THIS)
    List<String> merge(int v, List<String> subPath){
        // HOLY MOTHER OF GOD!!!! THIS IS THE FUCKING BEAUTY OF MAP REDUCE :P
        return subPath.stream()
                .map(p -> v + "->" + p)
                .collect(Collectors.toList());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();

        if(root == null) return path;

        if(root.left == null && root.right == null) {
            // leaf
            return Arrays.asList("" + root.val);
        }

        if(root.left != null){
            path.addAll(merge(root.val, binaryTreePaths(root.left)));
        }

        if(root.right != null) {
            path.addAll(merge(root.val, binaryTreePaths(root.right)));
        }

        return path;
    }

}
