public class width{

    public static void main(String[] args){
        int[] arr={10, 20,30,-1, 40,50,-1,-1,-1,-1,60,-1,70,80,-1,90,-1,100,-1,-1,-1};
        Node root = createTree(arr);


        System.out.println(widthOfTree(root, 0, new int[2]));
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

    public static int widthOfTree(Node node, int level, int[]maxmin){

        if(node == null) return 0;
        maxmin[0] = Math.max(maxmin[0], level); 
        maxmin[1] = Math.min(maxmin[1], level);

        int lans = widthOfTree(node.left, level-1, maxmin);
        int rans = widthOfTree(node.right, level+1, maxmin);

        return maxmin[0] - maxmin[1];
    }
}