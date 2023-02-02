import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class ArraySum {

  /**
   * Computes the cumulative sum on the interval [i, j]
   * repeatedly for 0 <= i <= N - 1 and i + 1 <= j <= N - 1.
   * The return format is a 2d integer matrix.
   *
   * @param A the integer array
   * @return  the cumulative sum matrix described above
   */
  public static int[][] arraysum(int[] A) {
    int N = A.length;
    int[][] B = new int[N][N];

    for (int i = 0; i < N; i++)
      for (int j = i; j < N; j++)
        for (int k = i; k <= j; k++)
          B[i][j] += A[k];
    return B;
  }

  /**
   * Faster implementation of cumulative sum computation
   * on interval [i, j], returning a matrix.
   *
   * @param A the integer array
   * @return  the cumulative sum matrix described above
   */
  public static int[][] arraysum_fast(int[] A) {
    int N = A.length;
    int[][] B = new int[N][N];

    for (int i = 0; i < N; i++)
      for (int j = i; j < N; j++)
        B[i][j] = (i == j) ? A[i] : A[j] + B[i][j - 1];
    return B;
  }

  /**
   * Prints a matrix computed by arraysum or arraysum_fast
   * to the standard output.
   *
   * @param B an integer matrix computed by arraysum or
   *          or arraysum_fast
   */
  public static void printres(int[][] B) {
    int N = B.length;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.print(B[i][j] + "\t");
      System.out.println();
    }
  }

  /**
   * Stochastic input generation given input size N.
   *
   * @param size of array to be generated
   */
  public static int[] generate_input(int N) {
    int[] A = new int[N];
    for (int i = 0; i < N; i++)
      A[i] = StdRandom.uniformInt(N);
    return A;
  }

  /**
   * Times a function with input size N.
   *
   * @param N input size
   * @param f function to time
   * @return  time it takes to run function
   */
  public static double timeFunc(int N, String f) {
    int[] A = generate_input(N);
    Stopwatch timer = new Stopwatch();

    int[][] ignore = (f.equals("fast")) ? arraysum_fast(A) : arraysum(A);
    return timer.elapsedTime();
  }

  /**
   * Test case.
   *
   * @param N size of integer array
   */
  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    String f = args[1];

    System.out.println("T\tN");
    for (int i = 1; i < N; i *= 2) {
      System.out.printf("%12d\t%7.1f\n", i, timeFunc(i, f));
    }

  }
}
