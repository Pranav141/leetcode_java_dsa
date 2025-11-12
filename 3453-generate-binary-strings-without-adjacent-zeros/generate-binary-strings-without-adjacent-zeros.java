class Solution {
    public void solve(List<String> res, String s,boolean prevZero,boolean onePre,int n){
        if(n==0 && onePre){
            res.add(s);
            return;
        }
        else if(n==0 && !onePre){
            return;
        }
        

        if(prevZero){
            solve(res,s+"1",false,true,n-1);
        }
        else{
            solve(res,s+"0",true,onePre,n-1);
            solve(res,s+"1",false,true,n-1);
        }
    }
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        if(n==1){
            res.add("0");
            res.add("1");
            return res;
        }
        solve(res,"",false,false,n);
        return res;
    }
}