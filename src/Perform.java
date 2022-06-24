public class Perform {
    public static String reverse(String a) {
        String rev = "";
        for (int i = a.length() - 1; i >= 0; i--)
            rev += a.charAt(i);
        return rev;
    }
}
