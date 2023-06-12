interface Area {
    final static float pi = 3.14f;

    float compute(float x, float y);
}

class Rectangle implements Area {
    public float compute(float x, float y) {
        return x * y;
    }
}

class Circle implements Area {
    public float compute(float x, float y) {
        return pi * x * x;
    }
}

public class InterfacePractice {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Circle circ = new Circle();

        System.out.println(rect.compute(10, 20));
        System.out.println(circ.compute(10, 0));

        Area area;
        area = rect;
        System.out.println(area.compute(10, 20));
        area = circ;
        System.out.println(area.compute(10, 0));

        circ = (Circle) area;
    }
}
