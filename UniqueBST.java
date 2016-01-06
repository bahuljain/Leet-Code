//bitch problem this was...surprisingly there was a very easy solution to this.
//should have gotten this

public class UniqueBST {
    // Dynamic Programming. Number of BST of size n is dependent on number of BST in
    // subtrees of size n-1.
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;

        // let j denote the size of BST
        for(int j = 1; j <= n; j++) {
            int s = 0;

            // Let i denote the size of subtree on left
            for(int i = 0; i < j; i++){

                // The total number of BST for this configuration is nothing but
                // the product of the subtrees on either sides
                s += nums[i] * nums[j - 1 - i];
            }
            nums[j] = s;
        }
        return nums[n];
    }
}
