import edu.princeton.cs.algs4.*;

public class CompareBST_Sim {

    @SuppressWarnings("unchecked")
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

        System.out.printf(
            "%d\t %d\t normal\t %10d \t %10.0f \t %10.8f\t %10.8f\n",
            n, trials, opt, avg_bst, tavg_bst, tbst_sd
        );
        System.out.printf(
            "%d\t %d\t redblk\t %10d \t %10.0f \t %10.8f\t %10.8f\n",
            n, trials, opt, avg_rbt, tavg_rbt, trbt_sd
        );


    }
}

