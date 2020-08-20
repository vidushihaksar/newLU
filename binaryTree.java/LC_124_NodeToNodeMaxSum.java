package binaryTree.java;

public class LC_124_NodeToNodeMaxSum {
    int nodeToNodeMax = -(int)1e8;
    public int maxPathSum(TreeNode root) {
        
        helper(root);
        return nodeToNodeMax;
    }
    
    public int helper(TreeNode root) {
        
        if(root == null) return -(int)1e8;
        
        int lmax = helper(root.left);
        int rmax = helper(root.right);
        
        int max_ = Math.max(lmax, rmax) + root.val;
        nodeToNodeMax = Math.max( Math.max(nodeToNodeMax, root.val), Math.max(max_, lmax + root.val + rmax) );
        
        return Math.max(max_ , root.val);
    }
}