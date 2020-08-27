import java.util.Stack;
public class levelorder_zigzag{
    public static void main(String[] args){
        int[] arr={12,13,-1,-1,10,14,21,-1,-1,24,-1,-1,15,22,-1,-1,23,-1,-1};
        Node root = createTree(arr);

        zigzag(root);
        
       
      
    }

    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;


        Node(int data){
            this.data = data;
        }
    }

    static int idx = 0 ;
    public static Node createTree(int[] a){
        if(a[idx] == -1  || idx == a.length){
            idx++;
            return null;
        }
        Node node = new Node(a[idx]);
        idx++;
        node.left = createTree(a);
        node.right = createTree(a);

        return node;

    }
    static int level = 0;

    public static void zigzag(Node node){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(node);

        while(st1.size() != 0){
            int size = st1.size();

            while(size-- > 0){
               Node rem = st1.pop();
               System.out.print(rem.data+" ");

               if(level % 2 == 0){
                    if(rem.left != null){
                      st2.push(rem.left);
                    }
    
                    if(rem.right != null){
                       st2.push(rem.right);
                    }
                }else{
                    if(rem.right != null){
                       st2.push(rem.right);
                    }
                    if(rem.left != null){
                       st2.push(rem.left);
                    }
                }
            }
            System.out.println();
            st1 = st2;
            st2 = new Stack<>();
            level++;
        }

        
    }


    //**************** Leetcode - 103 *********************** */
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
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>>ans = new ArrayList<>();
//         List<Integer>subans = new ArrayList<>();
        
//         if(root == null) return ans;
//         zigzag(root, ans, subans);
//         return ans;
        
//     }
    
    
//     int level = 0;
//     public  void zigzag(TreeNode node,List<List<Integer>>ans, List<Integer>subans){
//         Stack<TreeNode> st1 = new Stack<>();
//         Stack<TreeNode> st2 = new Stack<>();

//         st1.push(node);

//         while(st1.size() != 0){
//             int size = st1.size();

//             while(size-- > 0){
//                TreeNode rem = st1.pop();
//                subans.add(rem.val);

//                if(level % 2 == 0){
//                     if(rem.left != null){
//                       st2.push(rem.left);
//                     }
    
//                     if(rem.right != null){
//                        st2.push(rem.right);
//                     }
//                 }else{
//                     if(rem.right != null){
//                        st2.push(rem.right);
//                     }
//                     if(rem.left != null){
//                        st2.push(rem.left);
//                     }
//                 }
//             }
//             ans.add(new ArrayList<>(subans));
//             subans = new ArrayList<>();
//             st1 = st2;
//             st2 = new Stack<>();
//             level++;
//         }

        
//     }
// }
}