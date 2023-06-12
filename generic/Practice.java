public class Practice {
    public <T> void printArray(T[] a) {
        for (T x : a)
            System.out.println(x);
    }

    public static void main(String[] args) {
        Practice p1 = new Practice();
        Integer[] x = { 1, 2, 4, 6, 7, 8 };
        p1.printArray(x);
    }
}
