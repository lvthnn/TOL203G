import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;

public class LinkedListOfStrings {
  private int N; // size of list
  private Node first; // first node of list

  // helper Node class
  private static class Node {
    private String item;
    private Node next;
  }

  public LinkedListOfStrings() {
    N = 0;
    first = null;
  }

  // is the list empty?
  public boolean isEmpty() {
    return first == null;
  }

  // number of elements on the stack
  public int size() {
    return N;
  }

  // add an element to the front of the list
  public void addFront(String item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  // delete and return the first item in the list
  public String delFront() {
    if (isEmpty())
      throw new NoSuchElementException("No items in list");
    String item = first.item; // save item to return
    first = first.next; // delete first node
    N--;
    return item; // return the saved item
  }

  // delete and return the last item in the list
  public String delBack() {
    if (isEmpty())
      throw new NoSuchElementException("No items in list");

    Node curr = first;
    String item = first.item;
    if (N == 1) {
      curr = null;
    } else {
      while (curr.next.next != null) {
        curr = curr.next;
      }
      item = curr.next.item;
      curr.next = null;
    }

    N--;
    return item;
  }

  // print out the list
  public void printList() {
    Node x = first;
    for (int i = 0; i < N; i++) {
      System.out.println(x.item);
      x = x.next;
    }
  }

  // test client
  public static void main(String[] args) {
    LinkedListOfStrings list = new LinkedListOfStrings();
    list.addFront("item1");
    list.addFront("item2");
    list.addFront("item3");

    // Eyðing 1 : [2, 3] ætti að vera eftir
    list.printList();
    list.delBack();

    // Eyðing 2 : Bara 3 eftir
    list.printList();
    list.delBack();

    // Eyðing 3 : Ekkert eftir, tóm lína
    list.printList();
    list.delBack();

    list.printList();
  }

}
