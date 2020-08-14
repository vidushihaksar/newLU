public class LC_78_Subsets_1{
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
          List<List<Integer>> main_ans = new ArrayList<>();
            List<Integer> subans = new ArrayList<>();
            
            helper(nums, 0, main_ans, subans);
            return main_ans;
        }
        
        public void helper(int[] nums, int idx, List<List<Integer>> main_ans, List<Integer> subans){
            if(idx == nums.length){
                main_ans.add(new ArrayList<>(subans));
                return;
            }
            
            subans.add(nums[idx]);
            helper(nums, idx+1, main_ans, subans);
            subans.remove(subans.size()-1);
            
            helper(nums, idx+1, main_ans, subans);
        }
    }
}