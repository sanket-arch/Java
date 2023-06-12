class Box {
    private double l, b, h;

    Box() {
        l = 10;
        b = 10;
        h = 10;
    }

    Box(double l) {
        this.l = l;
    }

    Box(double l, double b) {
        this.l = l;
        this.b = b;
    }

    Box(double l, double b, double h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    double volume() {
        return l * b * h;
    }
}

class BoxColor extends Box {
    int c;

    BoxColor() {
    }

    BoxColor(double l, double w, double h, int c) {
        super(l, w, h); // commenting this statement will call the // default constructor of the super
                        // class
        this.c = c;
    }

    double volume() {
        // code
        return super.volume();
        // code
    }
}

public class SuperP {
    public static void main(String args[]) {
        BoxColor obj = new BoxColor(10, 20, 30, 5);
        System.out.println(obj.volume());
        Box b;
        b = obj; // super class refernce can recive subclass object
        System.out.println(b.volume());

        // obj=b //subclass object cannot recive the super class reference
        obj = (BoxColor) b; //since b is refering to the subclass object, subclass object can take the re
        System.out.println(obj.volume());
    }
}
