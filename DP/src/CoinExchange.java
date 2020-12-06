public class CoinExchange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int[] memo = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            memo[i] = amount + 1;
        }
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            if (memo[i] != amount + 1) return memo[i];
            for (int coin : coins) {
                if (i - coin < 0) continue;
                memo[i] = Math.min(1 + memo[i - coin], memo[i]);
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        CoinExchange coinExchange = new CoinExchange();
        int ret = coinExchange.coinChange2(new int[]{2}, 3);
        System.out.println(ret);
    }

    public int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        memo[0] = 0;
        return dp(memo, coins, amount);
    }

    public int dp(int[] memo, int[] coins, int i) {
        if (i < 0) return -1;
        if (i == 0) return 0;
        if (memo[i] != Integer.MAX_VALUE) return memo[i];
        int ret = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subproblem = dp(memo, coins, i - coin);
            if (subproblem == -1) continue;
            ret = Math.min(ret, 1 + subproblem);
        }
        memo[i] = ret == Integer.MAX_VALUE ? -1 : ret;
        return memo[i];
    }
}
