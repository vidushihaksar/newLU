import java.util.ArrayList;

public class mazePath {

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = 3;
        // int count = mazepath(0, 0, n-1, n-1, "" );
        // System.out.println(count);

        // int count = mazePath_infinte_jumps(0, 0, n - 1, n - 1, "");
        // System.out.println(count);
         
        int[][]a = {{1,0,0,0},{1,1,0,1},{0,1,0,0}, {0,1,1,1}};
        ArrayList<String> ans = printPath(a, 4);
        System.out.println(ans);
    }

    // *************** mazepath ************************************************ */
    public static int mazepath(int sr, int sc, int er, int ec, String path) {
        if (sr == er && sc == ec) {
            System.out.println(path);
            return 1;
        }

        int count = 0;
        if (sc + 1 <= ec) {
            count += mazepath(sr, sc + 1, er, ec, path + "H");
        }

        if (sr + 1 <= er) {
            count += mazepath(sr + 1, sc, er, ec, path + "V");

        }

        if (sr + 1 <= er && sc + 1 <= ec) {
            count += mazepath(sr + 1, sc + 1, er, ec, path + "D");
        }
        return count;
    }

    // *********** mazePath with infinite jumps ************************************
    public static int mazePath_infinte_jumps(int sr, int sc, int er, int ec, String path) {
        if (sr == er && sc == ec) {
            System.out.println(path);
            return 1;
        }

        int count = 0;
        for (int i = 1; sr + i <= er; i++) {
            count += mazePath_infinte_jumps(sr + i, sc, er, ec, path + "V" + i);
        }

        for (int i = 1; sc + i <= ec; i++) {
            count += mazePath_infinte_jumps(sr, sc + i, er, ec, path + "H" + i);
        }

        for (int i = 1; sr + i <= er && sc + i <= ec; i++) {
            count += mazePath_infinte_jumps(sr + i, sc + i, er, ec, path + "D" + i);
        }

        return count;
    }
 

    // ****** gfg - https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1 ********* */

    public static ArrayList<String> printPath(int[][] m, int n) {
        int dir[][] = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        String[] dirS = { "D", "L", "R", "U" };
        ArrayList<String> a = new ArrayList<>();

        // edge case
        if (n == 0 || m[0][0] == 0 || m[n - 1][n - 1] == 0) {
            return a;
        }

        helper(m, 0, 0, n - 1, n - 1, dir, dirS, a, "", new boolean[n][n]);
        return a;
    }

    public static void helper(int[][] m, int sr, int sc, int er, int ec, int[][] dir, String[] dirS,
            ArrayList<String> a, String path, boolean[][] visited) {
        if (sr == er && sc == ec) {
            a.add(path);

        }

        visited[sr][sc] = true; // mark visited

        // for (int jump = 1; jump <= m.length; jump++) {
            for (int i = 0; i < dir.length; i++) {
                int nr = sr +  dir[i][0];
                int nc = sc +  dir[i][1];

                if (nr >= 0 && nc >= 0 && nr <= er && nc <= ec && m[nr][nc] == 1 && !visited[nr][nc]) {
                    helper(m, nr, nc, er, ec, dir, dirS, a, path + dirS[i], visited);
                }
            }
        // }
        visited[sr][sc] = false;
    }

}