
import java.util.ArrayList;
public class kfar {
    
    public static void main(String[] args){
        int[] arr={10, 20,30,-1, 40,50,-1,-1,-1,-1,60,-1,70,80,-1,90,-1,100,-1,-1,-1};
        Node root = createTree(arr);

        
        Kfar(root,20 , 3);
        kfar_better(root, 3, 20);
      
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

    //*********** time O(2n)         Space O(n)        ************/
    public static void Kfar(Node node, int tar, int k){

        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath(node, tar, ans);

        Node block = null;
        for(Node n: ans){
            KDown(n, k, block);
            k--;
            block = n;
        }
    }

    public static boolean nodeToRootPath(Node n, int data  , ArrayList<Node> ans){
        if(n == null) return false;
        if(n.data == data){
            ans.add(n);
            return true;
        }

        boolean res = false;
         res = res || nodeToRootPath(n.left, data, ans);
         res = res || nodeToRootPath(n.right, data,ans);

        if(res){
            ans.add(n);
            return true;
        }

        return false;
    }

    public static void KDown(Node node, int k, Node block){

        if(node == null || k < 0 || node == block)  return;

        if(k == 0){
            System.out.println(node.data);
            return;
        }
        KDown(node.left, k-1, block);
        KDown(node.right, k-1, block);
       
    }




///*************** time O(n)  space O(1) */
    public static int kfar_better(Node node, int k, int tar){

        if(node == null ) return -1;
        if(node.data == tar) {
            
            KDown(node, k, null);
            return 1;
        }    

        int ld = kfar_better(node.left , k, tar);
        if(ld != -1){
            KDown(node, k-ld, node.left);
            return ld+1;
        }

        int rd = kfar_better(node.right, k, tar);
        if(rd != -1){
            KDown(node, k-rd, node.right);
            return rd+1;
        }


        return -1;
    }
}