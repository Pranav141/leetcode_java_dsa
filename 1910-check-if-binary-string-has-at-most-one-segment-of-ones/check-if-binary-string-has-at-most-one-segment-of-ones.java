class Solution {
    public boolean checkOnesSegment(String s) {
        int n=s.length();
        int i0=0;
        while(i0<n && s.charAt(i0)=='1' ) i0++;
        if (i0==n) return true;
        int i1=n-1;
        while( i1>=0 && s.charAt(i1)=='0' ) i1--;
        return i0>i1;

    }
}