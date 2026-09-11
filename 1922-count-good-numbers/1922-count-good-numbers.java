class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        // 5 choices for even indices: 0,2,4,6,8
        // 4 choices for odd indices: 2,3,5,7
        long ans = power(5, evenPositions) * power(4, oddPositions) % MOD;

        return (int) ans;
    }

    private long power(long base, long exponent) {
        long result = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exponent /= 2;
        }

        return result;
    }
}