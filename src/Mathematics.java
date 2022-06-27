import java.util.Arrays;

public class Mathematics {
    static boolean[] sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;
            }
        }
        return prime;
    }

    // GCD
    static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
