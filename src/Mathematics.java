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

    // Minimum sum of 4 digits
    static int minimumSum(int num) {
        int[] nums = new int[4];
        int i = 0;
        while (num > 0) {
            nums[i] = num % 10;
            i++;
            num /= 10;
        }
        Arrays.sort(nums);
        return (nums[2] + 10 * nums[0]) + (nums[3] + 10 * nums[1]);
    }

    // Number of good pairs
    static int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean pair = true;
            int k = 1;
            while (pair) {
                if ((i + k < nums.length) && (nums[i] == nums[i + k])) {
                    k++;
                    count++;
                } else pair = false;
            }
        }
        return count;
    }
}
