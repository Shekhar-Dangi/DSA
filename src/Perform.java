public class Perform {
    public static String reverse(String a) {
        String rev = "";
        for (int i = a.length() - 1; i >= 0; i--)
            rev += a.charAt(i);
        return rev;
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
