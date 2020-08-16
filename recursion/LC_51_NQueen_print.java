package recursion;

public class LC_51_NQueen_print {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>(); 
        List<String> path = new ArrayList<>();
        nQueen(new boolean[n][n], 0, n, ans, path, n);
        return ans;
    }
    
    public static void nQueen(boolean[][] box, int row, int tnq, List<List<String>> ans, List<String> path, int n ) {
        if(tnq == 0 || row == box.length) {
            if(tnq == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        
        StringBuilder s = new StringBuilder();
        for(int i =0; i<n; i++){
            s.append(".");
        }
        
        
        for(int i = 0; i < box[0].length; i++) {
            
            if(isSafe(box, row, i)) {
                
                box[row][i] = true;
                s = s.replace(i,i+1,"Q");
                String str = s.toString();
                path.add(str);
                nQueen(box, row + 1, tnq - 1, ans, path, n);
                box[row][i] = false;
                path.remove(path.size() - 1);
                s = s.replace(i,i+1,".");
            }
        }
    }
    
    public static boolean isSafe(boolean[][] box, int r, int c) {
        int[][] dirC = {{-1, 0}, {0, -1}, {-1, 1}, {-1, -1}};
        for(int[] dir: dirC) {
            for(int rad = 0; rad <= box.length; rad++){
                int i = r + rad * dir[0];
                int j = c + rad * dir[1];
                
                if(i >= 0 && i < box.length && j >= 0 && j < box[0].length && box[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}