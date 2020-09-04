/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode A= null, B= null, prev =null;
   
   public boolean helper(TreeNode root) {
       if(root == null) return false;
       
       if(helper(root.left)) return true;
       
      
       if(prev != null && prev.val > root.val){
          
            B = root;             
           if(A == null){ A = prev;}
           else return true;
         
          
       }
        prev = root;
      
       if(helper(root.right)) return true;
       
       return false;
   }
   
   public void recoverTree(TreeNode root) {

   
       helper(root);
       int t =A.val;
       A.val = B.val;
       B.val = t;
       
   }
}