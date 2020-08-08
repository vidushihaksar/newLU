public class floodfill {
    
    public static void main(String[] args){
        solve();
    }

    public static void solve(){
        floodfill_helper();
    }

    public static void floodfill_helper(){
       int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
       String[] dirS = {"U", "R", "D", "L"};
       int n = 8;
    //    int c = floodfill_4calls(0, 0, n-1, n-1, "", dir, dirS, new boolean[n][n]);
    //    System.out.println(c);

        int dir8[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}, {-1,1}, {1,1}, {1,-1}, {-1,-1}};
        String[] dirS8 = {"T", "R", "D", "L", "Tr", "Dr", "Dl", "Tl"};

        // int c = floodfill_8calls(0, 0, n-1, n-1, "", dir8, dirS8, new boolean[n][n]);
        // System.out.println(c);

        int dir_k[][] = {{2,1}, {1,2} , {-1,2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2, -1} };
        knights(0, 0, n-1, n-1, 1, dir_k, new int[n][n]);

    } 


//***********       floodfill - 4 calls             ************************************** */
    public static int floodfill_4calls(int sr, int sc, int er, int ec, String path, int[][]dir, String[] dirS, boolean[][]visited){
        if(sr == er && sc == ec){
            System.out.println(path);
            return 1;
        }
        
        int count = 0;
        //mark yourself
        visited[sr][sc] = true;

        //visit unvisited nbrs
        for(int i = 0; i < dir.length; i++){
            int nr = sr + dir[i][0];
            int nc = sc + dir[i][1];

            if(nr >= 0   &&   nc >= 0   &&   nr <= er   &&   nc <= ec   &&   !visited[nr][nc] ){
                count += floodfill_4calls(nr, nc, er, ec, path+dirS[i], dir, dirS, visited );
            }
        }

        //unmark yourself
        visited[sr][sc] = false;

        return count;

    }





//***********       floodfill - 8 calls             ************************************** */
    public static int floodfill_8calls(int sr, int sc, int er, int ec, String path, int[][]dir8, String[] dirS8, boolean[][]visited){
        if(sr == er && sc == ec){
            System.out.println(path);
            return 1;
        }
        
        int count = 0;
        //mark yourself
        visited[sr][sc] = true;

        //visit unvisited nbrs

        for(int jump =1; jump <= Math.max(visited.length, visited[0].length); jump++){

            for(int i = 0; i < dir8.length; i++){
                int nr = sr + jump * dir8[i][0];
                int nc = sc + jump * dir8[i][1];
    
                if(nr >= 0   &&   nc >= 0   &&   nr <= er   &&   nc <= ec   &&   !visited[nr][nc] ){
                    count += floodfill_8calls(nr, nc, er, ec, path + dirS8[i] + jump, dir8, dirS8, visited );
                }
            }
        }

        //unmark yourself
        visited[sr][sc] = false;

        return count;

    }


static int m = 0;
//**************   knights        ******************************************************************* */
    public static void knights(int sr, int sc, int er, int ec, int count, int[][]dir_k,  int[][]visited){
        int totalEle = (er+1)*(ec+1);

        if(count == totalEle){

            visited[sr][sc] = count;
            
            for(int k = 0; k <= er; k++){
                for(int l = 0; l <= ec; l++){
                    System.out.print(visited[k][l]+ " ");
                }
                System.out.println();
            }
            
            visited[sr][sc] = 0;
            m = 1;
            System.out.println();
            
            return;
        }
        
        //mark yourself
        visited[sr][sc] = count;

        //visit unvisited nbrs
        for(int i = 0; i < dir_k.length; i++){
            int nr = sr + dir_k[i][0];
            int nc = sc + dir_k[i][1];

            if(nr >= 0   &&   nc >= 0   &&   nr <= er   &&   nc <= ec   &&   visited[nr][nc]==0  && m== 0){
                 knights(nr, nc, er, ec,  count+1,  dir_k,  visited );
            }
        }

        //unmark yourself
        visited[sr][sc] = 0;

    }

}











