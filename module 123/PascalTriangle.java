public class PascalTriangle {
    public static void main(String[] args) {
       int numRows = 10; // number of rows to print
 
       // create a 2D array to store the values of Pascal's triangle
       int[][] pascal = new int[numRows][numRows];
 
       // initialize the first row and column to 1
       for (int i = 0; i < numRows; i++) {
          pascal[i][0] = 1;
          pascal[i][i] = 1;
       }
 
       // fill in the rest of the triangle
       outerLoop: // label the outer loop
       for (int i = 2; i < numRows; i++) {
          for (int j = 1; j < i; j++) {
             pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
             if (pascal[i][j] % 2 == 0) {
                continue outerLoop; // skip to the next iteration of the outer loop if the value is even
             }
          }
       }
 
       // print the triangle
       for (int i = 0; i < numRows; i++) {
          for (int j = 0; j <= i; j++) {
             System.out.print(pascal[i][j] + " ");
          }
          System.out.println();
       }
    }
 }
 