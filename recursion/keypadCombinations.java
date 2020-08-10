import java.util.ArrayList;

public class keypadCombinations {
   public static void main(String[] args){
       String digits= "10";

       ArrayList<String> c = letterCombinations_10_11(digits);
       System.out.println(c);
   }

//**************** leetcode  - 17  https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */
//******** without handling 10 and 11 case ********** */
    // public List<String> letterCombinations(String digits) {
    //     List<String> list = new ArrayList<String>();
        
    //     if(digits.length() == 0){
    //         return list;
    //     }
    //     String[] dic = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    //     int c = helper(digits,0, "", dic, list);
    //     return list;
    // }
    
    // public int helper(String digits, int idx, String ans, String[] dic, List<String> list){
    //  if(idx == digits.length()){
    //      list.add(ans);
    //      return 1;
         
    //  }
       
    //         char ch = digits.charAt(idx);
    //         String str = dic[ch-'0'];
    //         int count =0;
    //         for(int j =0; j< str.length(); j++){
    //            count += helper(digits, idx+1, ans + str.charAt(j), dic, list);
    //         }
    //     return count;
        
    // }





//**********  handled 10 and 11 case   *************/

    public static ArrayList<String> letterCombinations_10_11(String digits) {
        ArrayList<String> list = new ArrayList<String>();
        
        if(digits.length() == 0){
            return list;
        }
        String[] dic = {".,/?", "@#$%" ,"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz", "*+-", "&^!~"};
        int c = helper(digits,0, "", dic, list);
        return list;
    }
    
    public static int helper(String digits, int idx, String ans, String[] dic, ArrayList<String> list){
     if(idx == digits.length()){
         list.add(ans);
         return 1;
         
     }
       
            int cidx = digits.charAt(idx)-'0';
            String str = dic[cidx];

            int count =0;
            for(int j =0; j< str.length(); j++){
               count += helper(digits, idx+1, ans + str.charAt(j), dic, list);
            }

            if(idx < digits.length()-1){
                cidx = cidx * 10 + (digits.charAt(idx+1)-'0');
                if(cidx >= 10 && cidx <= 11){
                    str = dic[cidx];
                    for(int j =0; j< str.length(); j++){
                        count += helper(digits, idx+2, ans + str.charAt(j), dic, list);
                     }
                }
            }
        return count;
        
    }
}