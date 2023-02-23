import edu.princeton.cs.algs4.*;
import java.util.Scanner;

public class MedianFinder<Key extends Comparable<Key>> {
    private MaxPQ<Key> maxheap = new MaxPQ<>();
    private MinPQ<Key> minheap = new MinPQ<>();

    public MedianFinder() { }

    public Key findMedian() {
        if (minheap.size() == 0 && maxheap.size() == 0) return null;
        else if (maxheap.size() > minheap.size()) return maxheap.max();
        else return minheap.min();
    }

    public Key deleteMedian() {
        if (minheap.size() == 0 && maxheap.size() == 0) return null;
        else if (maxheap.size() > minheap.size()) return maxheap.delMax();
        else return minheap.delMin();
    }

    public void insert(Key key) {
        // ensure that we never enlarge maxheap to keep
        // median value at top of heap
        if (maxheap.size() == 0 || key.compareTo(maxheap.max()) < 0)
            maxheap.insert(key);
        else minheap.insert(key);

        // ensure that the heaps are of size
        // n and n+1 / n and n
        if (minheap.size() < maxheap.size() + 1) minheap.insert(maxheap.delMax());
        else if (maxheap.size() < minheap.size() + 1) maxheap.insert(minheap.delMin());
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