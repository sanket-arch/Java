class inheritMe {
    private int x;

    inheritMe() {
        System.out.println("cunstructor got called");
    }

    inheritMe(int x) {
        this();
        this.x = x;
    }

    public void methodName() {
        System.out.println("i am final method");
    }
}

public class Sample {
    private int x = 10;

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < args.length; i++)
            count += Integer.parseInt(args[i]);

        System.out.println(count);

    }
}
