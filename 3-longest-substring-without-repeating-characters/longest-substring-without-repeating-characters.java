class Solution {
    public int lengthOfLongestSubstring(String s) {
        int  i=0,j=0;
        char [] c = s.toCharArray();
        HashSet<Character> hc = new HashSet<>();
        int res = 0;
        while(j<c.length){
            while(hc.contains(c[j])){
                hc.remove(c[i]);
                i++;
            }
            hc.add(c[j]);
            res = Math.max(res,j-i+1);
            j++;
        }
        return res;
    }
}