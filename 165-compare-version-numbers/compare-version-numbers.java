class Solution {
    public int compareVersion(String v1, String v2) {
        String[] arr = v1.split("\\.");
        String[] arr1 = v2.split("\\.");

        for(int i=0;i<Math.max(arr.length,arr1.length);i++){
            int p1 = 0,p2 =0;
            if(i<arr.length){
                p1 = Integer.parseInt(arr[i]);
            }
            if(i<arr1.length){
                p2 = Integer.parseInt(arr1[i]);
            }
            
            if(p1<p2) return -1;
            if(p1>p2) return 1;

        }
        
        return 0;
    }
}