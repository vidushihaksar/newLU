// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
class Solution {
     
    //*********** without space ***********************
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       lca_better(root,p,q);
       return lca_node;
   }
   
   
   TreeNode lca_node = null;
   
   public  boolean lca_better(TreeNode node, TreeNode tar1, TreeNode tar2){
       
       if(node == null) return false;

       boolean selfdone = false;
       if(node.val == tar1.val || node.val == tar2.val){
          selfdone = true;
       }

       boolean leftdone = lca_better(node.left, tar1, tar2);
       if(lca_node != null){return true; }

       boolean rightdone = lca_better(node.right, tar1, tar2);
       if(lca_node != null){return true; }
       
       if( (leftdone && rightdone) || (leftdone && selfdone) || (selfdone && rightdone)){
           lca_node = node;
           return true;
       }
       
       return leftdone || selfdone || rightdone;
       
   
 }
    
    
    
    
    
    
    
    
    
    
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         List<TreeNode> ans1 =  rootToNodePath(root, p);
       
//         List<TreeNode> ans2 = rootToNodePath(root, q);
       
       
//         int i = ans1.size() -1;
//         int j = ans2.size() -1;
       
       
//         while(i >=0 && j >= 0){
//             if(ans1.get(i).val != ans2.get(j).val){
               
//                 break;
//             }
//             i--; j--;
//         }
//         return ans1.get(i+1);
//     }
   
//     public List<TreeNode> rootToNodePath(TreeNode root, TreeNode tar){
       
//         if(root == null) return new ArrayList<>();
       
//         if(root.val == tar.val){
//             List<TreeNode> ans1 = new ArrayList<>();
//             ans1.add(root);
//             return ans1;
//         }
       
       
//          List<TreeNode> ans1  = rootToNodePath(root.left, tar);
//         if(ans1.size() != 0){
//             ans1.add(root);
//             return ans1;
//         }
       
//          List<TreeNode> ans2  = rootToNodePath(root.right, tar);
//         if(ans2.size() != 0){
//             ans2.add(root);
//             return ans2;
//         }
       
//         return new ArrayList<>();
//     }
   
   
   
   
}


