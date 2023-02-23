import edu.princeton.cs.algs4.*;

public class MedianFinder<Key extends Comparable<Key>> {
    private MinPQ<Key> minheap = new MinPQ<Key>();
    private MaxPQ maxheap = new MaxPQ<Key>();

    public MedianFinder() { }

    public Key findMedian() {
        if (minheap.size() == 0 && maxheap.size() == 0) return null;
        if (maxheap.size() > minheap.size()) return (Key) maxheap.max();
        else return (Key) minheap.min();
    }

    public Key deleteMedian() {
        if (minheap.size() == 0 && maxheap.size() == 0) return null;
        if (maxheap.size() > minheap.size()) return (Key) maxheap.delMax();
        else return (Key) minheap.delMin();
    }

    public void insert(Key key) {
        // Check which heap to add key into
        if (maxheap.size() == 0 || key.compareTo((Key) maxheap.max()) < 0) maxheap.insert(key);
        else minheap.insert(key);

        // Ensure lengths of heaps are always n and n + 1
        // or n and n
        if (maxheap.size() > minheap.size() + 1) {
            Key tmp = (Key) maxheap.delMax();
            minheap.insert(tmp);
        } else if (minheap.size() > maxheap.size() + 1) {
            Key tmp = (Key) minheap.delMin();
            maxheap.insert(tmp);
        }
    }

    public static void main(String[] args) {
        MedianFinder<String> m = new MedianFinder<String>();
        StdOut.println(m.findMedian() + " er median");
        StdOut.println("Delete median " + m.deleteMedian());
        m.insert("A");
        m.insert("A");
        m.insert("B");
        StdOut.println("Delete median " + m.deleteMedian());
        StdOut.println("Delete median " + m.deleteMedian());
        StdOut.println("Delete median " + m.deleteMedian());
        StdOut.println("Delete median " + m.deleteMedian());
    }
}
