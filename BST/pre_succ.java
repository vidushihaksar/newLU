import java.util.ArrayList;
public class pre_succ {
    public static void main(String[] args){
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= 15; i++) arr.add(i*10);

        Node root = constructBST(arr,0,arr.size()-1);

        pred_succ_inorder(root,140);
        

    }

    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static Node constructBST(ArrayList<Integer> arr,int si,int ei){
        if(si>ei) return null; 

        int mid = (si + ei ) >> 1;
        Node node = new Node(arr.get(mid));

        node.left = constructBST(arr,si,mid - 1);
        node.right = constructBST(arr,mid + 1, ei);
        return node;
    }

    public static void pred_succ_inorder(Node node, int tar){
        Node curr = node;
        Node pred = null;
        Node succ = null;

        while(curr != null){

            if(curr.data ==  tar){

                //  predecessor
                if(curr.left != null){
                    pred = curr.left;
                    while(pred.right != null){
                        pred = pred.right;
                    }
                }

                //successor
                if(curr.right!= null){
                    succ = curr.right;
                    while(succ.left!= null){
                        succ = succ.left;
                    }
                }
                break;
                   
            }
            else if(curr.data < tar){
                curr = curr.right;
                pred = curr;          //potential  predecessor
            }
            else{
                curr = curr.left;
                succ = curr;         //potential successor

            }
        }

        System.out.println("Pred :"+pred.data + " Succ :" + succ.data);
    }





    
     //Leetcode 510.    // succ using parent pointer
    /*
    // Definition for a Node.
    class Node {
       public int val;
       public Node left;
       public Node right;
       public Node parent;
    };
    */

    // public Node inorderSuccessor(Node node) {
    //     Node curr = node;
    //     Node succ = null;
    //     if(curr.right!=null){
    //         succ = curr.right;
    //         while(succ.left != null) succ=succ.left;
            
    //         return succ;
    //     }
        
    //     Node prev = null;
    //     while(curr.parent!=null){
    //         prev = curr;
    //         curr = curr.parent;
    //         if(curr.left == prev) return curr;
    //     }
        
    //     return succ;
    // }
   
}