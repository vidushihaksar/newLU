
public class permutations {

    public static void main(String[] args) {

        solve();
    }

    public static void solve() {
        String str = "aba";
        int count = all_permutations(str, "");
        System.out.println(count);

        int c = permutations_without_reptitions(str, "");
        System.out.println(c);

    }

    // *********** permutations with reptitions ********************** */
    public static int all_permutations(String str, String ans) { // n! -> permutations
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            String nstr = str.substring(0, i) + str.substring(i + 1);
            count += all_permutations(nstr, ans + ch);

        }

        return count;
    }

    // ********* permutations without reptitions ************************** */
    public static int permutations_without_reptitions(String str, String ans) { // n! -> permutations
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        boolean[] visited = new boolean[26];
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String nstr = str.substring(0, i) + str.substring(i + 1);

            if( !visited[ch-'a'] ){
                count += permutations_without_reptitions(nstr, ans + ch);
            }

            visited[ch - 'a'] = true;

        }

        return count;
    }
}