import edu.princeton.cs.algs4.*;

public class CompareBST {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        boolean sorted = args[2].equals("sorted");

        double[] hbt = new double[trials]; // hæð á BSTum
        double[] hrb = new double[trials]; // hæð á RB-BSTum
        double[] tbst = new double[trials]; // timi fyrir bst
        double[] trbt = new double[trials]; // timi fyrir red-black bst
        
        for (int t = 0; t < trials; t++) {
            BST<Double, Integer> bst = new BST<>();
            RedBlackBST<Double, Integer> rbbst = new RedBlackBST();

            Stopwatch timer_bst = new Stopwatch();
            for (int i = 0; i < n; i++) {
              double curr = sorted ? i : StdRandom.uniformDouble();
              bst.put(curr, 1);
            }
            tbst[t] = timer_bst.elapsedTime();

            Stopwatch timer_rbt = new Stopwatch();
            for (int i = 0; i < n; i++) {
              double curr = sorted ? i : StdRandom.uniformDouble();
              rbbst.put(curr, 1);
            }
            trbt[t] = timer_rbt.elapsedTime();

            hbt[t] = bst.height();
            hrb[t] = rbbst.height();
        }

        // Prenta út niðurstöður...
        int opt = (int) Math.floor(Math.log(n) / Math.log(2));

        double avg_bst  = StdStats.mean(hbt);
        double avg_rbt  = StdStats.mean(hrb);

        double tavg_bst = StdStats.mean(tbst);
        double tbst_sd  = StdStats.stddev(tbst);
        double tavg_rbt = StdStats.mean(trbt);
        double trbt_sd  = StdStats.stddev(trbt);

        System.out.println("For n = " + n + ", optimal height is " + opt);
        System.out.printf("[Normal BST]\t Average height  in " + trials + " trials is %3.2f, %3.2f times optimal\n", avg_bst, avg_bst/opt);
        System.out.printf("[Normal BST]\t Average runtime in " + trials + " trials on " + (sorted ? "sorted " : "random ") + "input is %3.2f, sd %3.2f\n", tavg_bst, tbst_sd);
        System.out.printf("[Red-Black BST]\t Average height  in " + trials + " trials is %3.2f, %3.2f times optimal\n", avg_rbt, avg_rbt/opt);
        System.out.printf("[Red-Black BST]\t Average runtime in " + trials + " trials on " + (sorted ? "sorted " : "random ") + "input is %3.2f, sd %3.2f\n", tavg_rbt, trbt_sd);

    }
}

