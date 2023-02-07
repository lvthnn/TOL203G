
public class Test { 

  public static void main(String[] args) {
    Card[] testCases = {new Card(0, 1), new Card(1, 12), new Card(3, 13), new Card(2, 7)};
    for (Card card : testCases)
      System.out.println(card.toString());
  }

}
