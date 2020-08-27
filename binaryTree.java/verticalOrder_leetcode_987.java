/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        int[]maxmin = new int[2];
        int width =  widthOfTree(root, 0, maxmin);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < (maxmin[0]-maxmin[1]+1) ; i++){
            ans.add(new ArrayList<Integer>());
        }


        helper(root, ans,maxmin[1]);
        
        return ans;
    }
    
    
    
    //*********          vertical view      **********************/

    public  int widthOfTree(TreeNode node, int level, int[]maxmin){

        if(node == null) return 0;
        maxmin[0] = Math.max(maxmin[0], level); 
        maxmin[1] = Math.min(maxmin[1], level);

        int lans = widthOfTree(node.left, level-1, maxmin);
        int rans = widthOfTree(node.right, level+1, maxmin);

        return maxmin[0] - maxmin[1];
    }
   
  

    public  class pair {
        TreeNode n;
        int level;

        pair(TreeNode n, int level){
            this.n = n;
            this.level = level;
        }
        
        public int compareTo(pair o){
            return this.level-o.level;
        }
        
        
    }
    
   
    
    public  void helper(TreeNode node, List<List<Integer>> ans, int min){
        LinkedList<pair> que = new LinkedList<>();
        que.addLast(new pair(node, Math.abs(min)));

        while(que.size() != 0){
            int size = que.size();
            
            Map<Integer, List<Integer>> mp  =  new HashMap<Integer, List<Integer>>();
            
                
            while(size-- >0){
                pair rem = que.removeFirst();
                TreeNode n = rem.n;
                int level = rem.level;
                
                //
                if(mp.get(level)==null){
                    mp.put(level, new ArrayList<Integer>());
                }
                List<Integer> lvl = mp.get(level);
                lvl.add(n.val);
                 //
                

                if(n.left != null){
                   que.addLast(new pair(n.left, level-1));
                }


                if(n.right != null){
                    que.addLast(new pair(n.right, level+1));
                }

            }
           
            for(Map.Entry x: mp.entrySet()){
               //System.out.println(x);
               Collections.sort((List<Integer>)x.getValue());
               //System.out.println(x);
                
                int lvl = (int)x.getKey();
                for(int y: mp.get(lvl)) {     ans.get(lvl).add(y);     }

            }
            
        }
        
    }
     
}