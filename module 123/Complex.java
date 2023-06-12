public class Complex {
    private float realPart;
    private float imaginaryPart;

    Complex() {
        realPart = 0.0f;
        imaginaryPart = 0.0f;
    }

    Complex(float realPart, float imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public void add(Complex eq) {
        float resultReal = this.realPart + eq.realPart;
        float resultImg = this.imaginaryPart + eq.imaginaryPart;

        System.out.print("Addition of complex numbers are:  ");
        System.out.println(resultReal + "+" + resultImg + "i");
    }

    public void subtract(Complex eq) {
        float resultReal = this.realPart - eq.realPart;
        float resultImg = this.imaginaryPart - eq.imaginaryPart;
        System.out.print("Subtraction of complex numbers is :  ");
        System.out.println(resultReal + "+" + resultImg + "i");

    }

    public void display() {
        System.out.println("(" + realPart + "," + imaginaryPart + ")");
    }

    public static void main(String[] args) {
        Complex eq1 = new Complex(10.0f, 20.0f);
        Complex eq2 = new Complex(20.0f, 19.0f);

        System.out.print("Complex number 1: ");
        eq1.display();
        System.out.print("Complex number 2: ");
        eq2.display();

        eq1.add(eq2);
        eq1.subtract(eq2);
    }

}
