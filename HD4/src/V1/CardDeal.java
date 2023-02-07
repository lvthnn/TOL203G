import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

public class CardDeal {

  /**
   * Generates sorted array of playing cards.
   *
   * @return a deck of playing cards
   */
  public static Card[] generate_deck() {
    Card[] deck = new Card[52];
    for (int i = 0; i < 52; i++)
      deck[i] = new Card(i % 4, i % 13 + 1);
    Insertion.sort(deck);

    return deck;
  }

  /**
   * Gathers uniform k-sized sample from deck
   *
   * @param k number of cards in selection
   * @return  a random selection of k cards from the deck
   */
  public static Card[] deal_cards(int k, Card[] deck) {
    Card[] sample = new Card[k];
    StdRandom.shuffle(deck);

    for (int i = 0; i < k; i++) sample[i] = deck[i]; 

    return sample;
  }

  public static void main(String[] args) {
    int num_cards = Integer.parseInt(args[0]);
    Card[] deck = generate_deck();

    StdRandom.shuffle(deck);
    Card[] sample = deal_cards(num_cards, deck);
    for (Card card : sample) System.out.println(card.toString());

  }

}
