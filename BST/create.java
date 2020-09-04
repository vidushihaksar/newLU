import java.util.ArrayList;
public class create{
    public static void main(String[] args){
        solve();
    }

    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static void solve(){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= 15; i++) arr.add(i*10);

        Node root = constructBST(arr,0,arr.size()-1);

         display(root);
         System.out.println(size(root));
         System.out.println(height(root));
         System.out.println(find(root, 220));
         System.out.println(find_iterative(root, 220));
        
    }

    //Basic.==================================================================================

    public static Node constructBST(ArrayList<Integer> arr,int si,int ei){
        if(si>ei) return null; 

        int mid = (si + ei ) >> 1;
        Node node = new Node(arr.get(mid));

        node.left = constructBST(arr,si,mid - 1);
        node.right = constructBST(arr,mid + 1, ei);
        return node;
    }

    public static void display(Node node){
        if(node == null) return;

        StringBuilder sb  = new StringBuilder();
        sb.append(node.left != null? node.left.data : ".");
        sb.append("<- " + node.data + " ->");
        sb.append(node.right != null? node.right.data : ".");

        System.out.println(sb);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node){

        if(node == null)  return 0;
        int s = size(node.left) + size(node.right);
        return s+1;
    }

    public static int height(Node node){
        if(node == null)  return -1;
        int h = Math.max(height(node.left) , height(node.right));
        return h+1;
    }

    public static boolean find(Node node, int data){

        if(node == null) return false;
        if(node.data == data) return true;
        if(node.data > data) return find(node.left, data);
        else return find(node.right, data);

    }

    public static boolean find_iterative(Node node, int data){

        Node curr = node;
        while(curr != null){
            if(curr.data == data) return true;
            else if(curr.data > data) curr = curr.left;
            else curr = curr.right;
        }
        return false;
        

    }

}