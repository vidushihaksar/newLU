
public class pre_succ {
    
    public static void main(String[] args){
        int[] arr={12,13,-1,-1,10,14,21,-1,-1,24,-1,-1,15,22,-1,-1,23,-1,-1};
        Node root = createTree(arr);
        findPre_Succ(root, 24);
        System.out.println("pred : "+pred.data+"\nsucc :"+succ.data);

        allpair pair = new allpair();
        allsolutions(root, 24, 0, pair);
        System.out.println("\nheight " +pair.height);
        System.out.println("\nsize " +pair.size);
        System.out.println("\nceil " +pair.ceil);
        System.out.println("\nfloor " +pair.floor);
        System.out.println("\npred " +pair.pred.data);
        System.out.println("\nsucc " +pair.succ.data);

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


    static Node pred = null;
    static Node succ = null;
    static boolean found = false;
    public static void findPre_Succ(Node node, int tar){

        if(node == null)  return;
        findPre_Succ(node.left, tar);
        if(found) {
            succ = node;
            return;
        }
        if(node.data == tar){
            found = true;
        }
        if(!found) pred = node;


        findPre_Succ(node.right, tar);
    }


    public static class allpair{
        int height= 0,size=0;
        boolean find = false;
        Node previous= null, pred = null, succ = null;
        int ceil = (int)1e8;
        int floor = -(int)1e8;

    }

    public static void allsolutions(Node node, int tar,int level, allpair pair){

        if(node == null) return;

        pair.height = Math.max(pair.height, level);
        pair.size++;
        pair.find = node.data == tar ? true: pair.find;
        if(node.data > tar)  pair.ceil = Math.min(pair.ceil, node.data);
        if(node.data < tar) pair.floor = Math.max(pair.floor, node.data);


        allsolutions(node.left, tar, level+1, pair);

        if(node.data == tar && pair.pred == null) pair.pred = pair.previous;
        if(pair.previous != null && pair.previous.data == tar) pair.succ = node;
        pair.previous = node;

        allsolutions(node.right, tar, level+1, pair);
    }
}