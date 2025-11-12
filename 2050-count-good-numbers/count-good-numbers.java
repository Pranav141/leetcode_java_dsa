class Solution {
    public int MOD = 1000000000+7;
   private long power(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {  // If the lowest bit is 1 (odd)
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1; // Divide exp by 2
        }

        return result;
    }
    public int countGoodNumbers(long n) {
        // int even =5;
        // int prime = 4;
        long evenCount = (n+1)/2;
        long primeCount = n/2;
        int res =(int) (power(5,evenCount)%MOD * power(4,primeCount)%MOD)%MOD;
        return res;
    }
}