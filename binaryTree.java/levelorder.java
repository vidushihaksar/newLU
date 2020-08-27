import java.util.ArrayList;
import java.util.LinkedList;


public class levelorder{
    public static void main(String[] args){
        int[] arr={12,13,-1,-1,10,14,21,-1,-1,24,-1,-1,15,22,-1,-1,23,-1,-1};
        Node root = createTree(arr);

        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        bfs_01(root);
        System.out.println();
        bfs_linewise_01(root);
        System.out.println();
        bfs_linewise_using_delimiter(root);
        System.out.println();
        ArrayList<ArrayList<Integer>> ns= levelOrder(root);
        System.out.println(ns);
       
      
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

    public static void bfs_01(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);

        while(que.size() != 0){
            Node rem = que.removeFirst();
            System.out.print(rem.data+" ");

            if(rem.left != null){
                que.addLast(rem.left);
            }


            if(rem.right != null){
                que.addLast(rem.right);
            }
        }
    }


    public static void bfs_linewise_01(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);

        while(que.size() != 0){
            int size = que.size();

            while(size-- >0){
                Node rem = que.removeFirst();
                System.out.print(rem.data+" ");

                if(rem.left != null){
                   que.addLast(rem.left);
                }


                if(rem.right != null){
                   que.addLast(rem.right);
                }

            }
            System.out.println();
        }
    }


    public static void bfs_linewise_using_delimiter(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);
        que.add(null);

        while(que.size() >1){
            Node rm = que.removeFirst();

            if(rm == null){
                que.addLast(null);
                System.out.println();
            }else{
                System.out.print(rm.data+" ");
                if(rm.left != null){
                    que.addLast(rm.left);
                 }
 
 
                 if(rm.right != null){
                    que.addLast(rm.right);
                 }
 
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        ArrayList<Integer>subans = new ArrayList<>();
        
        if(root == null) return ans;
        bfs_linewise_using_delimiter_(root, subans, ans);
        return ans;
    }
    
     public  static void bfs_linewise_using_delimiter_(Node node, ArrayList<Integer>subans,ArrayList<ArrayList<Integer>>ans ){
         
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);
        que.add(null);

        while(que.size() >0){
            Node rm = que.removeFirst();

            if(rm == null ){
                if(subans.size() != 0){

                    que.addLast(null);
                    ans.add(new ArrayList<>(subans));
                    subans = new ArrayList<>();
                }else{
                    break;
                }
            }else{
                subans.add(rm.data);
                if(rm.left != null){
                    que.addLast(rm.left);
                 }
 
 
                 if(rm.right != null){
                    que.addLast(rm.right);
                 }
 
            }
            
        }
    }


}