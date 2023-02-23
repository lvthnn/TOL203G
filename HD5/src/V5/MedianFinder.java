import edu.princeton.cs.algs4.*;
import java.util.Scanner;

public class MedianFinder<Key extends Comparable<Key>> {
    private MaxPQ<Key> maxheap = new MaxPQ<>();
    private MinPQ<Key> minheap = new MinPQ<>();

    public MedianFinder() { }

    public Key findMedian() {
        if (minheap.isEmpty() && maxheap.isEmpty()) return null;
        else if (minheap.size() >= maxheap.size()) return (Key) minheap.min();
        else return (Key) maxheap.max();
    }

    public Key deleteMedian() {
        if (minheap.isEmpty() && maxheap.isEmpty()) return null;
        else if (minheap.size() >= maxheap.size()) return (Key) minheap.delMin();
        else return (Key) maxheap.delMax();
    }

    public void insert(Key key) {
      // Check which heap to add key into
      if (maxheap.isEmpty() || key.compareTo((Key) maxheap.max()) < 0) maxheap.insert(key);
      else minheap.insert(key);

      // Ensure lengths of heaps are always n and n + 1
      // or n and n
      if (maxheap.size() > minheap.size() + 1) minheap.insert((Key) maxheap.delMax());
      else if (minheap.size() > maxheap.size() + 1) maxheap.insert((Key) minheap.delMin());
    }

    public static void main(String[] args) {
        MedianFinder<String> m = new MedianFinder<String>();

        Scanner in = new Scanner(System.in, "UTF-8");
        while (in.hasNext()) m.insert(in.next());

        System.out.println(m.deleteMedian());
        System.out.println(m.deleteMedian());
        System.out.println(m.deleteMedian());
        System.out.println(m.deleteMedian());
    }

}
