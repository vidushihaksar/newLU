import java.util.ArrayList;

public class burningtree_gfg {
    public static void main(String[] args){
        int[] arr={12,13,-1,-1,10,14,21,-1,-1,24,-1,-1,15,22,-1,-1,23,-1,-1};
        Node root = createTree(arr);

        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        burnTree(root, 0, ans, 14);
        for(ArrayList<Integer> a : ans){

            System.out.println(a);
        }
      
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

    public static void burnNodes(Node n, int level, ArrayList<ArrayList<Integer>> ans){

        if(n == null)  return;
        if(ans.size() == level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(n.data);

        burnNodes(n.left, level+1, ans);
        burnNodes(n.right, level+1, ans);
    }

    public static int burnTree(Node n, int level, ArrayList<ArrayList<Integer>> ans, int tar){

        if(n == null) return -1;
        if(n.data == tar){
           
                // ans.add(new ArrayList<>());
                // ans.get(level).add(node.data);
                burnNodes(n, level, ans);
                return 1;
            
        }

        int lt = burnTree(n.left, level, ans, tar);
        if(lt != -1){
            if(ans.size() == level){
                ans.add(new ArrayList<>());
            }
            ans.get(lt).add(n.data);
            burnNodes(n.right, lt+1, ans);

            return lt+1;
        }

        int rt = burnTree(n.right, level, ans, tar);
        if(rt != -1){
            if(ans.size() == level){
                ans.add(new ArrayList<>());
            }
            ans.get(rt).add(n.data);
            burnNodes(n.left, rt+1, ans);

            return rt+1;
        }

        return -1;
    }
    
}