public class BinaryOp {
    static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    // Only non - repeating element in array where every other element repeats k times.
    static int findUniqueK(int[] a, int n, int k) {
        int count[] = new int[32];

        for (int i = 0; i < 32; i++)
            for (int j = 0; j < n; j++)
                if ((a[j] & (1 << i)) != 0) count[i] += 1;

        int res = 0;

        for (int i = 0; i < 32; i++)
            res += (count[i] % k) * (1 << i);

        return res;

       /* return res / (n % k);
      if element may occur more than once but not k times. */
    }

    // Only non - repeating element in array where every element repeats twice.
    static int findUnique2(int[] a, int n) {
        int res = 0;

        for (int i = 0; i < n; i++)
            res ^= a[i];

        return res;
    }

    // Two non - repeating elements in array where every element repeats twice
    static int[] find2Unique2(int[] a, int n) {
        int res = 0;
        for (int i = 0; i < n; i++)
            res ^= a[i];

        res = res & -res;
        int[] finalRes = new int[2];

        for (int i = 0; i < n; i++) {
            if ((a[i] & res) == 0) finalRes[0] ^= a[i];
            else finalRes[1] ^= a[i];
        }

        return finalRes;
    }

    // Find ith bit
    static int findIthBit(int n, int i) {
        return (n & (1 << i)) >> i;
    }

    // Set ith bit
    static int setIthBit(int n, int i) {
        return n | (1 << i);
    }

    // Clear ith bit
    static int clearIthBit(int n, int i) {
        return n & ~(1 << i);
    }

    // Stripping off the lowest set bit
    static int stripOffBit(int n) {
        return n & (n - 1);
    }

    // Get lower set bit
    static int getLowerSetBit(int n) {
        return n & -n;
    }

    // Add two binary
    static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        String res = "";

        while (i >= 0 || j >= 0) {
            int dig1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int dig2 = j >= 0 ? b.charAt(j) - '0' : 0;

            res += dig1 ^ dig2 ^ carry;
            carry = (dig1 + dig2 + carry) >> 1;

            i--;
            j--;
        }

        if (carry > 0) {
            res += carry;
        }
        return Perform.reverse(res);
    }

}
