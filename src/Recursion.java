public class Recursion {
    // Sum of n natural numbers
    static int sum(int n) {
        return n == 1 ? 1 : n + sum(n - 1);
    }

    // a raised to power b(a^b)
    static long pow(long a, long b) {
        return b == 0 ? 1 : a * pow(a, b - 1);
    }

    // Number of paths in a m * n matrix
    static int count(int m, int n) {
        return (m == 1 || n == 1) ? 1 : count(n - 1, m) + count(n, m - 1);
    }

    // Josephus Problem
    static int josephus(int n, int k) {
        if (n == 0)
            return 0;
        return (josephus(n - 1, k) + k) % n;
    }
}
