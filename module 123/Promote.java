public class Promote {
    public static void main(String args[]) {
        int i = 0;
        first: for (i = 0; i < 10; i++) {
                for (int l = 0; l < 20; l++) {
                    if (l == 10)
                        System.out.println(i);
                        continue first;
                }
        }

    }
}
