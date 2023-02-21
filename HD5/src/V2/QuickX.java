import edu.princeton.cs.algs5.StdStats;

public class QuickX {

  public static void sort(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi+1;
    
    // Select partitioning element using 
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi+1;

  }

  // =============================================
  // HELPER METHODS
  // =============================================

  // Exchange two elements in array
  public static void exch(Comparable[] a, int i, int j)
  { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

  // Is v less than w?
  public static boolean less(Comparable v, Comparable w)
  { return v.compareTo(w) < 0; }

  private static void show(Comparable[] a) {
      for (int i = 0; i < a.length; i++)
          System.out.print(a[i] + " ");
      System.out.println();
  }

  // Is the array sorted?
  public static boolean isSorted(Comparable[] a) {
      for (int i = 1; i < a.length; i++)
          if (less(a[i], a[i-1])) return false;
      return true;
  }

  // TEST CLIENT
  public static void main(String[] args) {
    

  }
}
