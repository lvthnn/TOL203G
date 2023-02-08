import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class Random {

  private Random() {  }

  // is the array a[] sorted?
  private static boolean isSorted(Comparable[] a) {
      return isSorted(a, 0, a.length - 1);
  }

  // is the array sorted from a[lo] to a[hi]
  private static boolean isSorted(Comparable[] a, int lo, int hi) {
      for (int i = lo + 1; i <= hi; i++)
          if (less(a[i], a[i-1])) return false;
      return true;
  }

  // is the comparable v less than w?
  private static boolean less(Comparable v, Comparable w)
  { return v.compareTo(w) < 0; }

  // exchange items in array
  private static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  // sort using random sort method
  public static void sort(Comparable[] a) {
    int n = a.length;

    while (!isSorted(a)) {
      int i, j;
      i = StdRandom.uniformInt(0, n);
      j = StdRandom.uniformInt(i, n);
      if (less(a[j], a[i])) exch(a, i, j); 
    }
  }

  // print array to standard output
  public static void show(Comparable[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++)
      System.out.println(a[i]);
  }

  public static double timeFunc(Comparable[] a) {
    Stopwatch timer = new Stopwatch();
    Random.sort(a);
    return timer.elapsedTime();
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    In in = new In(args[1]);

    Integer[] a = Arrays.stream(in.readAllInts())
                        .boxed().toArray(Integer[]::new);

    for (int i = 0; i < n; i++) {
      StdRandom.shuffle(a);
      System.out.println(timeFunc(a));
    }
  }

}
