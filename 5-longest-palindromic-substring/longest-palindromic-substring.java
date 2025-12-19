class Solution {
    // public boolean isPalindrome(char[] c,int j,int j){
    //     while(i<j){
    //         if()
    //     }
    // }
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int imax=0,jmax=0;
        int max=0;
        for(int i=0;i<c.length;i++){
            int j = i, k = i;
            while (j >= 0 && k < c.length && c[j] == c[k]) {
                j--;
                k++;
            }
            int len = k - j - 1;
            if (len > max) {
                max = len;
                imax = j + 1;
                jmax = k;
            }

            // Even length palindrome
            j = i;
            k = i + 1;
            while (j >= 0 && k < c.length && c[j] == c[k]) {
                j--;
                k++;
            }
            len = k - j - 1;
            if (len > max) {
                max = len;
                imax = j + 1;
                jmax = k;
            }
        }
        
        return s.substring(imax,jmax);
    }
}