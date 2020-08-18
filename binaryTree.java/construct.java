public class construct {
    

    public static void main(String[] args){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = createTree(arr);
        display(root);
        // System.out.println(size(root));
        // System.out.println(height(root));
        // preorder(root);
        // postorder(root);
        // inorder(root);

        System.out.println("Diameter = " + diameter_01(root));   // O(n^2)
        System.out.println("Diameter = " + diameter_02(root)[0]);  //O(n)
        int h = diameter_03(root);
        System.out.println("Diameter = " + dia);  //O(n)


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


    //*****       size         **************** */
    public static int size(Node root){

        if(root == null) return 0;

        int size = size(root.left) + size(root.right);
        return size + 1;
    } 


    //*******       height           ************** */
    public static int height(Node node){
        if(node == null) return -1;

        int myHeight = Math.max( height(node.left), height(node.right) );
        return myHeight + 1;
    }

    //******   preorder      *********** */
    public static void preorder(Node node){
        if(node == null) return;

        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }

    //******   postorder      *********** */
    public static void postorder(Node node){
        if(node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }


    //******   inorder      *********** */
    public static void inorder(Node node){
        if(node == null) return;

        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }


    //*******  display   *********** */
    public static void display(Node node){
        if(node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append(node.left != null ? node.left.data+"" : ".");
        sb.append(" <- " + node.data + " -> ");
        sb.append(node.right != null ? node.right.data+"" : ".");

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);
    } 


    
    //******* diameter O(n2)      ********* */
    public static int diameter_01(Node node){
        if(node == null) return 0;

        int ld = diameter_01(node.left);
        int rd = diameter_01(node.right);

        int lh = height(node.left);
        int rh = height(node.right);

        return Math.max(Math.max(ld,rd), lh + rh + 2);   //+2 for edges
    }


    //******* diameter O(n)     0 -> dia,   1 -> height ********* */
    public static int[] diameter_02(Node node){
        if(node == null) return new int[]{0,-1};

        int[] lans = diameter_02(node.left);
        int[] rans = diameter_02(node.right);

        int dia = Math.max( Math.max(lans[0], rans[0]), lans[1] + rans[1] +2);
        int height = Math.max( lans[1], rans[1] )+1;
       

        return new int[]{dia, height};
    }


    //******* diameter O(n)   Using static variable   ********* */

    static int dia = 0;    // assume that this static variable dia contains Max(ldia, rdia)
    public static int diameter_03(Node node){
        if(node == null) return -1;

        int lh = diameter_03(node.left);
        int rh = diameter_03(node.right);

        dia = Math.max(dia, lh + rh + 2 ) ;
        
        return Math.max(lh, rh) +1;
    }



}