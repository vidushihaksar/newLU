package recursion;

public class LC_77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> main_ans  = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();

        helper(k, n, 1, main_ans, subans);
        return main_ans;
    }
    
    public void helper(int k, int n, int idx, List<List<Integer>> main_ans, List<Integer> subans){
        
        if(k == 0){
             List<Integer> mini_ans = new ArrayList<>(subans);
             main_ans.add(mini_ans);
             
             return;
        }
        
        
        
        
        for(int i = idx; i<= n; i++){
            subans.add(i);
            helper(k-1, n, i+1, main_ans, subans);
            subans.remove(subans.size()-1);
        }
        
        
    }
}