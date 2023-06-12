public class Strignp {
    public static void main(String[] args) {
        // String s = new String("Sanket");
        // s = "immutable";
        // char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
        // String s = new String(str, 2, 4);
        // System.out.println(s);
        // char[] x = new char[10];
        // s.getChars(2, 5, x, 0);
        // int x = 10;
        // String s = Integer.toString(x);
        // String s1 = new String("GeeksForGeeks");
        // String s2 = new String("geeksForGeeks");

        // // System.out.println(s1.regionMatches(true, 1, s2, 1, s1.length() - 1));

        // System.out.println(s1.compareTo(s2));

        // String[] strs = "Programming in# Java".split("# ");
        // for (int i = 0; i < strs.length; i++)
        // System.out.println(strs[i]);

        String s = new String("Programming in Java");
        System.out.println(s.startsWith("Programming"));
        System.out.println(s.endsWith("Java"));

    }
}
