class Solution {
    public int solve(int n,int k){
        if(n==1){
            return 0;
        }

        int res = solve(n-1,(k+1)/2);
        if(res==0){
            if(k%2==0){//even 2nd 
                return 1;
            }
            else{//1st
                return 0;
            }
        }
        else{//1
            if(k%2==0){//odd 1st
                return 0;
            }
            else{
                return 1;
            }
        }
    }
    public int kthGrammar(int n, int k) {
        return solve(n,k);
    }
}