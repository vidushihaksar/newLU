public class kdown {
    public static void main(String[] args){
        int[] arr={10, 20,30,-1, 40,50,-1,-1,-1,-1,60,-1,70,80,-1,90,-1,100,-1,-1,-1};
        Node root = createTree(arr);


       KDown(root, 3);
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

    public static void KDown(Node node, int k){

        if(node == null) return;

        if(k == 0){
            System.out.println(node.data);
            return;
        }
        KDown(node.left, k-1);
        KDown(node.right, k-1);
       
    }
}