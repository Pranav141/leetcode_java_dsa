class Solution {
    public boolean solve(char[][] board,int idx,
    int row,int col,char[] word,int n,int m,boolean[][] visited){
        // System.out.println(idx + " "+ word.length);
        if(idx>word.length-1){
            return false;
        }
        if(idx == word.length-1 && word[idx] == board[row][col]){
            return true;
        }
        if(word[idx] != board[row][col] || col == m || row == n){
            return false;
        }
        
        if(word[idx] == board[row][col]){
            boolean right = false,left = false,up= false,down= false;
            //right
            if(col < m-1 && !visited[row][col+1]){
                visited[row][col+1] = true;
                right = solve(board,idx+1,row,col+1,word,n,m,visited);
                visited[row][col+1] = false;
            }
            //down
            if(row < n-1 && !visited[row+1][col]){
                visited[row+1][col] = true;
                down = solve(board,idx+1,row+1,col,word,n,m,visited);
                visited[row+1][col] = false;
            }
            //left
            if(col>0 && !visited[row][col-1]){
                visited[row][col-1] = true;
                left = solve(board,idx+1,row,col-1,word,n,m,visited);
                visited[row][col-1] = false;
            }
            //up
            if(row > 0 && !visited[row-1][col]){
                visited[row-1][col] = true;
                up = solve(board,idx+1,row-1,col,word,n,m,visited);
                visited[row-1][col] = false;
            }
            return right || left || down || up;
        }
        else{
            return false;
        }
    }
    class Pair<T,R>{
        T row;
        R col;
        public Pair(T row,R col){
            this.row = row;
            this.col = col;
        }
    }

    public boolean exist(char[][] board, String word) {
        // from any position i can go in 4 directions up down left right
        // but the catch is that we cant go beyond the boundary 
        // if we go in a direction we check wheater we have got the character
        // that we were looking for or not
        // if not then return 
        boolean[][] visited =new  boolean[board.length][board[0].length];
        char[] wordArr = word.toCharArray();
        char toFind = wordArr[0];
        List<Pair<Integer,Integer>> arr = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == toFind){
                    arr.add(new Pair<Integer,Integer>(i,j));
                    // System.out.println(i+" "+j);
                }
            }
        }

        for(int i=0;i<board.length;i++){
            Arrays.fill(visited[i],false);
        }

        for(int i=0;i<arr.size();i++){
            int row = arr.get(i).row;
            int col = arr.get(i).col;
            visited[row][col] = true;
            boolean res= solve(board,0,row,col,word.toCharArray(),board.length,board[0].length,visited);
            visited[row][col] = false;
            if(res) return true;
        }
        return false;
    }
}