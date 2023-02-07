public class Card implements Comparable<Card>{
  private int rank;
  private int suit;

  public Card(int suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public int compareTo(Card c) {
    int cmp;
    if (suit == c.suit) {
      cmp = (rank < c.rank) ? -1 : (rank > c.rank) ? 1 : 0;
      if (rank == 1) cmp = (rank == c.rank) ? 0 : 1;
      else if (c.rank == 1) cmp = (rank == c.rank) ? 0 : -1;
    }
    else cmp = (suit < c.suit) ? -1 : 1;
    return cmp;
  }

  public String toString() {
    char[] suits = {'S', 'H', 'D', 'C'};
    String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    
    return suits[suit] + "-" + ranks[rank - 1];
  }
}
