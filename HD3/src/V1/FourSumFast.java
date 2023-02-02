
/******************************************************************************
 * Compilation: javac FourSumFast.java
 * Execution: java FourSumFast < input.txt
 * Dependencies: StdIn.java StdOut.java
 *
 * A program with N^4 running time. Read in N long integers
 * and counts the number of 4-tuples that sum to exactly 0.
 *
 * Limitations
 * -----------
 * - we ignore integer overflow
 *
 ******************************************************************************/

import java.util.Arrays;

public class FourSumFast {

  // returns true if the sorted array a[] contains any duplicated integers
  private static boolean containsDuplicates(long[] a) {
    for (int i = 1; i < a.length; i++)
      if (a[i] == a[i - 1])
        return true;
    return false;
  }

  // print distinct 4-tuples (i, j, k, l) such that a[i] + a[j] + a[k] + a[l] = 0
  public static int printAll(long[] a) {
    int N = a.length;
    Arrays.sort(a);
    if (containsDuplicates(a))
      throw new IllegalArgumentException("array contains duplicate integers");
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        for (int k = j + 1; k < N; k++) {
          int l = Arrays.binarySearch(a, -(a[i] + a[j] + a[k]));
          if (l > k)
            System.out.println(a[i] + " " + a[j] + " " + a[k] + " " + a[l]);
        }
      }
    }
    return cnt;
  }


  // return number of distinct 4-tuples (i, j, k, l) such that a[i] + a[j] + a[k]
  // + a[l] = 0
  public static int count(long[] a) {
    int N = a.length;
    Arrays.sort(a);
    int cnt = 0;
    if (containsDuplicates(a))
      throw new IllegalArgumentException("array contains duplicates");
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        for (int k = j + 1; k < N; k++) {
          int l = Arrays.binarySearch(a, - (a[i] + a[j] + a[k]));
          if (l > k) cnt++;
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    long[] a = new long[N];
    for (int i = 0; i < N; i++) {
      a[i] = StdIn.readLong();
    }
    int cnt = count(a);
    StdOut.println(cnt);
    if (cnt < 10) {
      printAll(a);
    }
  }
}
