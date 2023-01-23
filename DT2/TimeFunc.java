import edu.princeton.cs.algs4.Stopwatch;

public class TimeFunc {

  public static long sum(long N) {
    long sum = 0; 
    for (long i=1; i<=N; i=2*i)
      for (long j=1; j<=2*i; j++) 
        sum++;
    return sum;
  }

  public static double timeTrial(long N) {
    Stopwatch timer = new Stopwatch();
    long ignore = sum(N);
    return timer.elapsedTime();
  }
  
  public static void main(String[] args) {
    for (long N = 1; N <= Long.MAX_VALUE; N = 2*N) {
      System.out.printf("%12d\t%7.1f\n", N, timeTrial(N));
    }
  }

}
