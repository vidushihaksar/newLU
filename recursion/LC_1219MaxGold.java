package recursion;

public class LC_1219MaxGold{
    
    public  int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(n == 0 || m== 0){
            return 0;
        }
        
        int[][]dir= {{0,-1},{0,1},{-1,0},{1,0}};
        
        int maxgold = 0;
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    maxgold =  Math.max(maxgold, getMaxGold(grid, i, j, dir));
                }
            }
        }
        return maxgold;
    }
    
    public  int getMaxGold(int[][] grid, int sr, int sc, int[][] dir){
        
        
        
        // Mark visited
        grid[sr][sc] = - grid[sr][sc];
        
         int maxgold = 0;
        for(int i =0; i< dir.length; i++){
        int nr = sr + dir[i][0]; 
        int nc = sc + dir[i][1];
            
        if(nr >=0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] > 0){
                
            maxgold = Math.max(maxgold , getMaxGold(grid, nr, nc, dir)); 
            
            }
        }
        
        //mark unvisited
        grid[sr][sc] = - grid[sr][sc];
        return maxgold + grid[sr][sc];
        
    }
}