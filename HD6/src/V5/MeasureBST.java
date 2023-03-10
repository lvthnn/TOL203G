import edu.princeton.cs.algs4.*;

public class MeasureBST {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        double[] h = new double[trials];
        
        for (int t = 0; t < trials; t++) {
            BST<Double, Integer> bst = new BST<>();
            for (int i = 0; i < n; i++)
              bst.put(StdRandom.uniformDouble(), 1);

            h[t] = bst.height();
        }

        // Prenta út niðurstöður...
        int opt = (int) Math.floor(Math.log(n) / Math.log(2));
        double avg = StdStats.mean(h);

        System.out.println("For n = " + n + ", optimal height is " + opt);
        System.out.printf("Average height in " + trials + " is %3.2f, %3.2f times optimal", avg, avg/opt);

    }
}
