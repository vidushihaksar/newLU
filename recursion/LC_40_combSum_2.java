public class LC_40_combSum_2{



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> main_ans  = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        Arrays.sort(candidates);     // need to sort arrays because answer is given in that way 
        
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
        
        
        HashSet<Integer> vis = new HashSet<>();
        int count = 0;
        
        for(int i = idx; i< a.length; i++){
            
            if(tar - a[i] >= 0 && !vis.contains(a[i])){
                subans.add(a[i]);
                vis.add(a[i]);
                
                 count += helper(a, tar-a[i], i+1, subans, main_ans);
            
                subans.remove(subans.size()-1);
            }
        }
        
        
        
        return count;
    }
}