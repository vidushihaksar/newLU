import java.util.ArrayList;
import java.util.LinkedList;

public class BSTFromPre_post_levelorder {
    public static void main(String[] args){
        //  from preorder
        // int[] arr = {7,3,1,0,2,6,4,5,12,9,8,11,10,13,15,14};
        // Node root = createFromPreorder(arr, -(int)1e8, (int)1e8);
        // display(root);

        // //from postorder
        // int[] a ={0,2,1,5,4,6,3,8,10,11,9,14,15,13,12,7};
        // i = a.length-1;
        // System.out.println();
        // Node r = createFromPostorder(a, -(int)1e8, (int)1e8);
        // display(r);

        //from levelorder
        System.out.println();
        int[] ar= {7,3,12,1,6,9,13,0,2,4,8,11,15,5,10,14};
        Node n  = createFromLevelorder(ar);
        display(n);



    }

    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }
    
    public static void display(Node node){
        if(node==null) return;
        StringBuilder sb = new StringBuilder();
        
        sb.append(node.left!=null?node.left.data+"" : ".");
        sb.append(" <- " + node.data + " -> ");
        sb.append(node.right!=null?node.right.data+"" : ".");

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);
    }

    static int idx =0;
    public static Node createFromPreorder(int[] arr, int lRange, int rRange){

        if(idx >= arr.length || arr[idx] < lRange || arr[idx] > rRange)  return null;

        Node root = new Node(arr[idx++]);
        root.left = createFromPreorder(arr, lRange, root.data);
        root.right = createFromPreorder(arr, root.data, rRange);

        return root;
        
    }


    static int i = 16;
    public static Node createFromPostorder(int[] arr, int lRange, int rRange){

        if(i < 0 || arr[i] < lRange || arr[i] > rRange)  return null;

        Node root = new Node(arr[i--]);
        root.right = createFromPostorder(arr, root.data, rRange);
        root.left = createFromPostorder(arr, lRange, root.data);

        return root;
        
    }

    public static class pair{
        int lRange;
        int rRange;
        Node parent;
        boolean lchild;

        pair(int lRange, int rRange, Node parent, boolean lchild ){
            this.lRange = lRange;
            this.rRange = rRange;
            this.parent= parent;
            this.lchild = lchild;
        }
    }
    static int indx= 0;

    public static Node createFromLevelorder(int[] arr){

        LinkedList<pair> que = new LinkedList<>();
        Node root = null;
        que.addLast(new pair(-(int)1e8, (int)1e8, null, false ));


        while(que.size() > 0 && indx < arr.length){

            pair rem = que.removeFirst();
            if(arr[indx] > rem.lRange && arr[indx] < rem.rRange){
                Node n = new Node(arr[indx++]);

                if(root == null) root = n;
                if(rem.parent != null){
                    if(rem.lchild) rem.parent.left = n;
                    else rem.parent.right = n;
                }
                que.addLast(new pair(rem.lRange, n.data, n, true));
                que.addLast(new pair(n.data, rem.rRange, n, false));

            }
        }
        return root;

    }

}