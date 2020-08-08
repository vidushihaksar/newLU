package recursion;

public class LC_980_UniquePaths_3 {



    //*************    leetcode - 980 https://leetcode.com/problems/unique-paths-iii/ ***** */
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(n == 0 || m== 0){
            return 0;
        }
        
        int[][]dir= {{0,-1},{0,1},{-1,0},{1,0}};
        int sr = -1,sc = -1, er = -1,ec = -1, count = 0;
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
              
                if(grid[i][j] == 0){ count++; }
                if(grid[i][j] == 1){ sr = i;    sc = j; }
                if(grid[i][j] == 2){ er = i ;   ec = j ;}
            
            }
        }
        
        int ans = helper(sr, sc, er, ec, grid, dir, count+1);
        return ans;
    }
    
    public int helper(int sr,int sc, int er, int ec, int[][] grid, int[][] dir, int count){
        if(sr == er && sc == ec && count == 0){
            return 1;
        }
        
        int temp = grid[sr][sc];
        grid[sr][sc] = -1;
        count -= 1;
        int paths = 0;
        
        for(int i =0; i< dir.length; i++){
           int nr = sr + dir[i][0]; 
           int nc = sc + dir[i][1];
            
           if(nr >=0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] != -1){
                paths += helper(nr, nc, er, ec, grid, dir, count);
            
            
            }
        }
        
        grid[sr][sc] = temp;
        
        return paths;
        
    }






    // ************* leetcode - 62 Unique Paths ********************** */
    public int uniquePaths(int m, int n) {
        int a[][] = new int[m][n];
        int c = helper(0, 0, m - 1, n - 1, a);
        return c;
    }

    public int helper(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        int count = 0;

        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }

        if (sr + 1 <= er)
            count += helper(sr + 1, sc, er, ec, dp);

        if (sc + 1 <= ec)
            count += helper(sr, sc + 1, er, ec, dp);

        return dp[sr][sc] = count;
    }


    // ************ leetcode - 63 Unique Paths with obstacle **********************
    // https://leetcode.com/problems/unique-paths-ii/ ********* */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int a[][] = new int[m][n];
        int c = helper(obstacleGrid, 0, 0, m - 1, n - 1, a);
        return c;
    }

    public int helper(int[][] obstacleGrid, int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        int count = 0;

        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }

        if (sr + 1 <= er && obstacleGrid[sr + 1][sc] == 0)
            count += helper(obstacleGrid, sr + 1, sc, er, ec, dp);

        if (sc + 1 <= ec && obstacleGrid[sr][sc + 1] == 0)
            count += helper(obstacleGrid, sr, sc + 1, er, ec, dp);

        return dp[sr][sc] = count;
    }

}