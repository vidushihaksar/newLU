package recursion;

public class LC_216_CombSum_3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> main_ans  = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        helper(k,n,1,0,main_ans, subans);
        return main_ans;
    }
    
    public static void helper(int k, int n, int idx, int sum, List<List<Integer>> main_ans, List<Integer> subans){
        if(k == 0){
            if (sum == n){
               List<Integer> mini_ans = new ArrayList<>(subans);
               main_ans.add(mini_ans);
            }
            return;
        }
        
        for(int i=idx; i<=9; i++){
            subans.add(i);
            helper(k-1, n, i+1, sum+i, main_ans, subans);
            subans.remove(subans.size()-1);
        }
    }
}