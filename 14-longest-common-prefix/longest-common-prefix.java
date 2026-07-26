class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s = strs[0];

        for(int i=0;i<strs.length;i++){
            if(strs[i].startsWith(s)){
                continue;
            }
            while(!strs[i].startsWith(s)){
                s = s.substring(0,s.length()-1);
            }
            if(s.length()==0){
                break;
            }
        }
        return s;
    }
}