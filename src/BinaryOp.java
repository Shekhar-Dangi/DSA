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
    
    // Reverse Bits of a number
    static int reverseBits(int n) {
        /*
        String bin = Integer.toBinaryString(n);
        bin = String.format("%32s", bin).replaceAll(" ", "0");
        int res = 0;
        for(int i = bin.length() - 1;i >= 0;i--){
            if(bin.charAt(i) == '1')
                res += Math.pow(2, i);
        }
        return res;
         */
        int res = 0;
        for(int i = 0;i < 32;i++){
            res <<= 1;

            if ((n & 1) == 1) res |= 1;
            n >>>= 1;
        }
        return res;
    }
    
    // Counting the number of '1' bits number has (also known as the Hamming weight)
    static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0;i < 32;i++){
            if((n & 1) == 1)
                count++;
            n >>>= 1;
        }
        return count;
    }
    
    // Check if a number can be expressed in power of 2
    static boolean isPowerOfTwo(int n) {
        int count = 0;
        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            n >>= 1;
        }
        return count == 1;
    }
    
    // Finding missing number when array [0, n-1] contain numbers in range [0, n] and one is missing
    static int missingNumber(int[] nums) {
        int res = 0;
        int len = nums.length;
        for(int i = 0;i < len;i++){
            res ^= i ^ nums[i];
        }
        res ^= len;
        return res;
    }
    
    // Given an integer n, return an array of number of bits at each index
    static int[] countBits(int n) {
        int res[] = new int[n + 1];
        for(int i = 0;i <= n;i++){
            int count = 0;
            int k = i;
            for(int j = 0;j < 32;j++){ 
                if((k & 1) == 1)
                    count++;
                k >>>= 1;
            }
            res[i] = count;
        }
    return res;
    }
}
