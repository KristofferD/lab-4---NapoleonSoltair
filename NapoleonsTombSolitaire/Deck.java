import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;
    private long deckSeed;

    public long getSeed() {
        return deckSeed;
    }

    public Deck() {
        this(new Random().nextLong());
    }

    public Deck toDeck() {
        Deck deck = new Deck();
        deck.addCards(cards);
        clear();
        return deck;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Deck(Long seed) {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int rank = 1; rank <= 13; rank++) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
        deckSeed = seed;
        shuffle(deckSeed);
    }

    public void shuffle() {
        shuffle(deckSeed);
    }

    public void shuffle(long seed) {
        Collections.shuffle(cards, new Random(seed));
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public int getRemainingCards() {
        return cards.size();
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }
    
    public void clear() {
        this.cards.clear();
    }
}
