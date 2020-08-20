package binaryTree.java;

public class LC_113_pathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> mainans = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        
        if(root == null) return mainans;
        helper(root, sum, mainans, subans);
        return mainans;
        
    }
    
    public void helper(TreeNode node , int sum,  List<List<Integer>> mainans, List<Integer> subans ){
     
        if(node == null) return;
        
        if(node.left == null && node.right == null ){
            if( (sum - node.val) == 0 ){
                subans.add(node.val);
                mainans.add(new ArrayList<>(subans));
                subans.remove(subans.size()-1);
            }
            
            return;
        }
        
        subans.add(node.val);
        helper(node.left, sum - node.val, mainans, subans);
        helper(node.right, sum- node.val, mainans, subans);
        subans.remove(subans.size()-1);
        
        
    }
}