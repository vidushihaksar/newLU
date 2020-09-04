/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    //     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //         if(root == null) return null;
            
    //         if(p.val > q.val){
    //             TreeNode temp = p;
    //             p = q;
    //             q = temp;
    //         }
            
    //         if(p.val < root.val && root.val < q.val) return root;
    //         else if( p == root || q == root) return root;
    //         else if(q.val < root.val) return lowestCommonAncestor(root.left,p,q);
    //         else return lowestCommonAncestor(root.right,p,q);
    //     }
        
        
        // ****** iterative **********
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
            if(p.val > q.val){
                TreeNode temp = p;
                p = q;
                q = temp;
            }
            
           TreeNode curr = root;
            while(curr != null){
                if(curr == p || curr == q) return curr;
                else if(curr.val > p.val && curr.val < q.val) return curr;
                else if(curr.val > q.val) curr = curr.left;
                else curr = curr.right;
            }
            
            return null;
            
        }
    
    
    }