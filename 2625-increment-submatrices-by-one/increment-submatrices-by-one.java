class Solution {
    public int[][] rangeAddQueries(int n, int[][] q) {
        int[][] mat = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(mat[i],0);
        }
        for(int i=0;i<q.length;i++){
            int r1=q[i][0];
            int c1=q[i][1];
            int r2=q[i][2];
            int c2=q[i][3];
            for(int j=r1;j<=r2;j++){
                mat[j][c1]++;
                if(c2<n-1){
                    mat[j][c2+1]--;
                }
            }

        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                mat[i][j] = mat[i][j] + mat[i][j-1];
            }
        }
        return mat;
    }
}