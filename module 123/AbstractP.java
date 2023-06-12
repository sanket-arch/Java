interface Shape {
    double area();
}

interface DataOnly {
    int YES = 1;
    int NO = 0;
    double DONT_KNOW = 0.5;

    int x();
}

class Triangle implements Shape {
    double d1, d2, d3;

    Triangle() {
    }

    Triangle(double d1, double d2, double d3) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public double area() {
        double s = (d1 + d2 + d3) / 2;
        return Math.sqrt(s * (s - d1) * (s - d2) * (s - d3));
    }
}

class Rectangle implements Shape {
    double d1, d2;

    Rectangle() {
    }

    Rectangle(double d1, double d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    public double area() {
        return d1 * d2;
    }

    double perimeter() {
        return 2 * (d1 + d2);
    }
}

public class AbstractP {

    public static void main(String args[]) {
        Shape sh; // reference to the interface
        Triangle ob = new Triangle(3, 4, 5);
        Rectangle ob1 = new Rectangle(10, 20);
        sh = ob; // interface refernce can recieve object
        System.out.println(sh.area()); // area of triangle object
        sh = ob1;
        System.out.println(sh.area());// area of rectange object
        // ob = sh; // object canot recieve interface referance
        // ob = (Triangle) sh;// this will compile but it will give run time error
        ob1 = (Rectangle) sh; // this code run because currently sh is currently referencing to ob1

        // Accessing the data of the interface
        System.out.println(DataOnly.DONT_KNOW);

    }

}