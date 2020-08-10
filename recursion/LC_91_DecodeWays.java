
public class LC_91_DecodeWays {
    public static void main(String[] args) {
        String s = "12";
        int c= numDecodings(s);
        System.out.println(c);
    }


    public static int numDecodings(String s) {
        if(s.length() == 0) return 0;
       int c =  helper(s, 0,"");
        return c;
        
    }
    
    public static int helper(String s, int idx, String ans){
        if(idx == s.length()){
            System.out.println(ans);
            return 1;
        }
        
        
        int num = s.charAt(idx)-'0';
        if(num == 0) return 0;  //  01001 cannot be decoded
        
        int count=0;
        count += helper(s, idx+1, ans + (char)(num + 'a' -1));
        
        if(idx < s.length()-1){
            num = num * 10 + (s.charAt(idx+1)-'0');
            if(num >= 10 && num <= 26){
                count += helper(s, idx+2, ans + (char)(num + 'a' -1));
            }
        }
        return count;
        
        
    }
}