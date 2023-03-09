import edu.princeton.cs.algs4.*;

public class CompareBST {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        String sorted = args[2];

        double[] hbt = new double[trials]; // hæð á BSTum
        double[] hrb = new double[trials]; // hæð á RB-BSTum
        
        for (int t = 0; t < trials; t++) {
            BST<Double, Integer> bst = new BST<>();
            RedBlackBST<Double, Integer> rbbst = new RedBlackBST();

            for (int i = 0; i < n; i++) {
              double curr;
              if (sorted.equals("sorted")) curr = i;
              else curr = StdRandom.uniformDouble();
              bst.put(curr, 1);
              rbbst.put(curr, 1);
            }
            hbt[t] = bst.height();
            hrb[t] = rbbst.height();
        }

        // Prenta út niðurstöður...
        int opt = (int) Math.floor(Math.log(n) / Math.log(2));
        double avg_bst = StdStats.mean(hbt);
        double avg_rbt = StdStats.mean(hrb);

        System.out.println("For n = " + n + ", optimal height is " + opt);
        System.out.printf("[Normal BST]\t Average height in " + trials + " is %3.2f, %3.2f times optimal\n", avg_bst, avg_bst/opt);
        System.out.printf("[Red Black BST]\t Average height in " + trials + " is %3.2f, %3.2f times optimal\n", avg_rbt, avg_rbt/opt);

    }
}

