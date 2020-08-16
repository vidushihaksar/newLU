package recursion;

public class LC_90_Subsets_2 {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            
            List<List<Integer>> main_ans = new ArrayList<>();
            List<Integer> subans = new ArrayList<>();
            Arrays.sort(nums);
            helper(nums, 0, main_ans, subans);
            return main_ans;
        }
        
        public void helper(int[] nums, int idx, List<List<Integer>> main_ans, List<Integer> subans){
            
            main_ans.add(new ArrayList<Integer>(subans));
            
            
            for(int i = idx; i< nums.length; i++){
                
                if(i > idx && nums[i] == nums[i-1]){  continue; }    // i > idx bcus ele on idx will not be a duplicate 
                   subans.add(nums[i]);
                   helper(nums, i+1, main_ans, subans);
                   subans.remove(subans.size()-1);
                
            }
           
        }
    }
}