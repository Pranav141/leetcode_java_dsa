class Solution {
    public void solve(char[] digits,String[] comb,int n,String s,List<String> res){
        if(digits.length == s.length()){
            String temp = new String(s);
            // System.out.println(s);
            res.add(temp);
            return;
        }
        if(n==digits.length){
            // System.out.println("23");
            
            return;
        }
        int digit = digits[n]-'0';
        String temp = comb[digit];
        char[] tempArr = temp.toCharArray();
        for(int i = 0;i<tempArr.length;i++){
            solve(digits,comb,n+1,s+tempArr[i],res);
        }

    }
    public List<String> letterCombinations(String digits) {
        char[] carr= digits.toCharArray();
        //digits - char arr
        //comb - combinatios
        //s - res string
        //res
        String[] comb = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        solve(carr,comb,0,"",res);
        return res;
    }
}