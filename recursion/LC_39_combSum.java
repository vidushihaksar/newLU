public class LC_39_combSum{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> main_ans  = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        
        int count = helper(candidates, target, 0,  subans,  main_ans);
        return (main_ans);
    }
    
    
    
    public int helper(int[]a, int tar, int idx,List<Integer> subans, List<List<Integer>> main_ans ){
     if(tar == 0 || a.length == idx){
         
         if(tar == 0){
             List<Integer> mini_ans = new ArrayList<>(subans);
             main_ans.add(mini_ans);
             return 1;
         }
         return 0;
     }
        
        
        
        int count = 0;
        if(tar - a[idx] >= 0 ){
            subans.add(a[idx]);
            count += helper(a, tar-a[idx], idx, subans, main_ans);
            subans.remove(subans.size()-1);
        }
        count += helper(a, tar, idx+1, subans, main_ans);
        
        
        return count;
    }
}