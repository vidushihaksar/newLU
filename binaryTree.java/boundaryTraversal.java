public class boundaryTraversal {
    public static void main(String[] args){
        int[] arr={4,10,5,-1,6,8,11,3,5,-1,-1,8,-1,-1,-1,-1,8,3,8,-1,-1,6,-1,-1,4,-1,11,-1,-1,5,7,-1,8,-1,1,11,-1,-1,-1,-1,20,-1,-1};
        Node root = createTree(arr);

        
        boundary(root);
      
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

    public static void boundary(Node root){

        System.out.print(root.data+" ");
        printLeftTree(root.left);
        printLeftTreeLeaves(root);
        printRightTree(root.right);
    }

    public static void printLeftTree(Node root){
        if(root == null) return;
        if(root.left == null && root.right == null) return;

        System.out.print(root.data+" ");
        if(root.left != null ) printLeftTree(root.left);
        else if(root.right!= null)printLeftTree(root.right);
    
    }
    public static void printLeftTreeLeaves(Node root){

        if(root == null) return;
        if(root.left == null && root.right == null){
            System.out.print(root.data+" ");
            return;
        }

        printLeftTreeLeaves(root.left);
        printLeftTreeLeaves(root.right);
    }

    public static void printRightTree(Node root){

        if(root == null) return;
        if(root.left == null && root.right == null) return;

        if(root.right!= null) printRightTree(root.right);
        else if(root.left != null ) printRightTree(root.left);
        System.out.print(root.data+" ");

    }
}


// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.printBoundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> ans= new ArrayList<>();
	    ans.add(node.data);
        printLeftTree(node.left, ans);
        printLeftTreeLeaves(node, ans);
        printRightTree(node.right, ans);
        return ans;
	    
	}
	
	
    public static void printLeftTree(Node root, ArrayList<Integer> ans ){
        if(root == null) return;
        if(root.left == null && root.right == null) return;

        ans.add(root.data);
       if(root.left != null ) printLeftTree(root.left,ans);
        else if(root.right!= null)printLeftTree(root.right,ans);
    
    }
    public static void printLeftTreeLeaves(Node root, ArrayList<Integer> ans){

        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.add(root.data);
            return;
        }

        printLeftTreeLeaves(root.left, ans);
        printLeftTreeLeaves(root.right, ans);
    }

    public static void printRightTree(Node root, ArrayList<Integer> ans){

        if(root == null) return;
        if(root.left == null && root.right == null) return;

        if(root.right!= null) printRightTree(root.right, ans);
        else if(root.left != null ) printRightTree(root.left, ans);
        ans.add(root.data);

    }
}


// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.printBoundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> ans= new ArrayList<>();
	    ans.add(node.data);
        printLeftTree(node.left, ans);
        printLeftTreeLeaves(node, ans);
        printRightTree(node.right, ans);
        return ans;
	    
	}
	
	
    public static void printLeftTree(Node root, ArrayList<Integer> ans ){
        if(root == null) return;
        if(root.left == null && root.right == null) return;

        ans.add(root.data);
       if(root.left != null ) printLeftTree(root.left,ans);
        else if(root.right!= null)printLeftTree(root.right,ans);
    
    }
    public static void printLeftTreeLeaves(Node root, ArrayList<Integer> ans){

        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.add(root.data);
            return;
        }

        printLeftTreeLeaves(root.left, ans);
        printLeftTreeLeaves(root.right, ans);
    }

    public static void printRightTree(Node root, ArrayList<Integer> ans){

        if(root == null) return;
        if(root.left == null && root.right == null) return;

        if(root.right!= null) printRightTree(root.right, ans);
        else if(root.left != null ) printRightTree(root.left, ans);
        ans.add(root.data);

    }
}