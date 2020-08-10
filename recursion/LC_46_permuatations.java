
public class LC_46_permuatations {
    


//******** Lettcode-46  https://leetcode.com/problems/permutations/      ******** */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallans =  new ArrayList<>();
        int count = 0 ;
        boolean[] visited = new boolean[nums.length];
        
        helper(nums, count, res, smallans, visited);
        
        return res;
        
    }
    
    
    public void helper(int[] nums, int count, List<List<Integer>> res, List<Integer> smallans, boolean[] visited){
        
        if(count == visited.length){
            List<Integer> ans =  new ArrayList<>(smallans);
            res.add(ans);
        }
        
        for(int i =0; i< nums.length; i++){
            
            if( !visited[i] ){
                
                visited[i] = true;     // block 
                smallans.add(nums[i]);     //add in AL
                
                helper(nums, count + 1, res, smallans, visited);
                
                visited[i] = false;     // unblock  it because we have to find other permutations also
                smallans.remove(smallans.size()-1);      //also remove it from answer AL
                
                 
            }
        }
    }



//******* leetcode - 47 https://leetcode.com/problems/permutations-ii/submissions/ */

public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> smallans =  new ArrayList<>();
    int count = 0 ;
    boolean[] visited = new boolean[nums.length];
    
    helper(nums, count, res, smallans, visited);
    
    return res;
    
}

public void helper(int[] nums, int count, List<List<Integer>> res, List<Integer> smallans, boolean[] visited){
    
    if(count == visited.length){
        List<Integer> ans =  new ArrayList<>(smallans);
        res.add(ans);
    }
    
    HashSet<Integer> hs = new HashSet<>();       // hashSet is used to remove duplicates
    
    for(int i =0; i< nums.length; i++){
        
        if( !visited[i] && !hs.contains(nums[i])){
            
            hs.add(nums[i]);
            visited[i] = true;     // block 
            smallans.add(nums[i]);     //add in AL
            
            helper(nums, count + 1, res, smallans, visited);
            
            visited[i] = false;     // unblock  it because we have to find other permutations also
            smallans.remove(smallans.size()-1);      //also remove it from answer AL
            
             
        }
    }
}



//********* leetcode 47 approach -2 */
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> smallans =  new ArrayList<>();
    int count = 0 ;
    boolean[] visited = new boolean[nums.length];
    Arrays.sort(nums);
    helper(nums, count, res, smallans, visited);
    
    return res;
    
}

    
    // ************  using previous and current in place of visited hashset ******
public void helper(int[] nums, int count, List<List<Integer>> res, List<Integer> smallans, boolean[] visited){
    
    if(count == visited.length){
        List<Integer> ans =  new ArrayList<>(smallans);
        res.add(ans);
    }
    
    int prev = (int)-1e8;
    for(int i =0; i< nums.length; i++){
        
        if( !visited[i] && prev != nums[i] ){

            visited[i] = true;     // block 
            smallans.add(nums[i]);     //add in AL
            
            helper(nums, count + 1, res, smallans, visited);
            
            visited[i] = false;     // unblock  it because we have to find other permutations also
            smallans.remove(smallans.size()-1);      //also remove it from answer AL
            
            prev = nums[i];
             
        }
        
             
        
    }
}
}









}