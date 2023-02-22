import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class QuickX {

  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length-1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int j = partition(a, lo, hi);
    sort(a, lo, j-1);
    sort(a, j+1, hi);
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi+1;
    
    int m = median(a, lo, (lo+hi)/2, hi);
    Comparable v = a[m];
    exch(a, lo, m);

    while (true) {
      while (less(a[++i], v)) if (i == hi) break;
      while (less(v, a[--j])) if (j == lo) break;
      if (i >= j) break;
      exch(a, i, j);
    }

    exch(a, lo, j);
    return j;
  }

  private static int median(Comparable[] a, int i, int j, int k) {
    return (less(a[i], a[j]) ?
           (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
           (less(a[k], a[j]) ? k : less(a[k], a[i]) ? k : i));
  }

  /**
   * HELPER METHODS
   */

  public static void exch(Comparable[] a, int i, int j)
  { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

  public static boolean less(Comparable v, Comparable w)
  { return v.compareTo(w) < 0; }

  public static boolean isSorted(Comparable[] a) {
      for (int i = 1; i < a.length; i++)
          if (less(a[i], a[i-1])) return false;
      return true;
  }

  public static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
    System.out.println();
  }

  /**
   * Test client, run with -ea flag.
   *
   * @param N size of list
   */
  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);

    int[] T = new int[N];
    for (int i = 0; i < N; i++)
      T[i] = StdRandom.uniformInt(1, 10);

    Integer[] test = Arrays.stream(T).boxed().toArray(Integer[]::new);

    sort(test);
    assert isSorted(test);

  }
}
