public class Test {
    private int x = 10;
    private int y = 20;
    private int z = 94;
    // private int[] name = new int[10];
    private int[] num = { 1, 2, 3, 4, 5 };

    // This is a constructor of class Test
    public Test(int i) {
        x = i;
    }

    public Test(int i, int j) {
        this(i); // calling constructor with one argument
        y = j;
    }

    public Test(int i, int j, int k) {
        this(i, j); // calling constructor with two argument
        z = k;
    }

    public void printArray() {
        for (int i : num) {
            System.out.println(i);
        }
    }

    public void thisDemo(int x, int y) {
        System.out.println(this.x);
        System.out.println(this.y);
    }

    public void methodOfClass() {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    public static void main(String[] args) {
        // Test obj1 = new Test(90, 21, 87); // creating object of class TEST
        // methodOfClass(); //we can directly call the class method when it with static
        // access modifier
        // obj1.methodOfClass();
        InnerTest s = new InnerTest();
        s.name();
        s.methodOfparentClass();
        s.declare();
        // obj1.thisDemo(60, 80);

        // obj1.printArray();
    }
}

abstract class ParentClass  {
    public void methodOfparentClass() {
        System.out.println("i am from parent class");
    }

    abstract void declare();
}

class InnerTest extends ParentClass {
    public void name() {
        Test obj2 = new Test(40);
        obj2.methodOfClass();
        System.out.println("hello");
       
       

    }

    @Override
    public void methodOfparentClass() {
        System.out.println("i am overriding parent class");
    }

    @Override
    void declare() {
        System.out.println("i am abstract method");
    }
}