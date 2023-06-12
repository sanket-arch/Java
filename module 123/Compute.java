interface oprate<T> {
    void multiply(T param);

    void add(T param);
}

class Vector implements oprate<int[]> {
    private int[] xyzValue = new int[3];
    private int[] addResult = new int[3];
    private int[] mulResult = new int[3];

    Vector(int[] values) {
        xyzValue = values;
    }

    public void add(int[] secondvector) {

        for (int i = 0; i < 3; i++) {
            addResult[i] = this.xyzValue[i] + secondvector[i];
        }
        System.out.println(addResult[0] + "i +" + addResult[1] + "j +" + addResult[2] + "k ");
    }

    public void multiply(int[] secondvector) {
        for (int i = 0; i < 3; i++) {
            mulResult[i] = xyzValue[i] * secondvector[i];
        }
        System.out.println(mulResult[0] + "i +" + mulResult[1] + "j +" + mulResult[2] + "k ");
    }
}

class Matrix implements oprate<int[][]> {
    private int[][] matrix;
    private int[][] addResult;
    private int[][] mulResult;

    Matrix(int[][] matrix) {
        this.matrix = matrix;
        addResult = new int[matrix.length][matrix[0].length];
        mulResult = new int[matrix.length][matrix[0].length];
    }

    public void add(int[][] secondMatrix) {
        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                addResult[i][j] = this.matrix[i][j] + secondMatrix[i][j];
            }
        }

        for (int i = 0; i < addResult.length; i++) {
            for (int j = 0; j < addResult[0].length; j++) {
                System.out.print(addResult[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public void multiply(int[][] secondMatrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < secondMatrix[0].length; k++) {
                    mulResult[i][j] += matrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        for (int i = 0; i < mulResult.length; i++) {
            for (int j = 0; j < mulResult[0].length; j++) {
                System.out.print(mulResult[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}

public class Compute {
    public static void main(String[] args) {

        // opration on vectors
        int[] eq1 = { 1, 2, 3 }; // contain x-axis,y-axis,z-axis values at index 0,1,2 respectively
        Vector v1 = new Vector(eq1);
        int[] eq2 = { 3, 5, 7 };

        System.out.print("Additon of the vector is:  ");
        v1.add(eq2);

        System.out.print("Multiplication of the vector is :  ");
        v1.multiply(eq2);

        System.out.println("\n");
        // opration on matrix
        int[][] mat1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] mat2 = { { 4, 2, 2 }, { 6, 7, 4 }, { 1, 5, 3 } };
        Matrix mat = new Matrix(mat1);

        System.out.println("Additon of the matrix is: ");
        mat.add(mat2);
        System.out.println("Multiplication of the matrix is:  ");
        mat.multiply(mat2);
    }

}
