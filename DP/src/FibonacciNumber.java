public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber f = new FibonacciNumber();
    }

    public int fib(int N) {
        if (N < 1) return 0;
        int[] memo = new int[N + 1];
        return helper(memo, N);
    }

    public int helper(int[] memo, int n) {
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    public int fib2(int N) {
        if (N == 0) return 0;
        int[] dp = new int[N + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}
