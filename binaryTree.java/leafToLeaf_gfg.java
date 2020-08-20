
//https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/

public class leafToLeaf_gfg {
    
 class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} 
class Tree
{
    public int leafToLeafMax = -(int)1e8;
    int maxPathSum(Node root)
    { 
        // code here 
        
        int max = helper(root);
       return (leafToLeafMax);
    } 
    
    int helper(Node node){
        
       
        if(node == null){ return -(int)1e8; }
         if(node.left == null && node.right == null){
            return node.data;
        }
        
        
        int lmax = helper(node.left);
        int rmax = helper(node.right);
        
        if(node.left != null && node.right != null){
            leafToLeafMax = Math.max(leafToLeafMax, lmax + node.data + rmax );
        }
        
        return Math.max(lmax, rmax) + node.data;
    }
}
}