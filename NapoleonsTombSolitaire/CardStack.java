import java.util.ArrayList;
import java.util.List;

public abstract class CardStack {
    protected List<Card> cards;

    public CardStack() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public abstract Card getTopCard();

    public List<Card> removeCards(int count) {
        List<Card> removedCards = new ArrayList<Card>();
        for (int i = 0; i < count; i++) {
            removedCards.add(cards.remove(cards.size() - 1));
        }
        return removedCards;
    }

    public boolean canRemoveCards(int count) {
        return cards.size() >= count;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getTopCards(int count) {
        if (count > size()) {
            return null; // Not enough cards to get
        }
        List<Card> topCards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            topCards.add(cards.get(cards.size() - count + i));
        }
        return topCards;
    }

    public boolean canAddCards(List<Card> newCards) {
        if (cards.isEmpty()) {
            return newCards.get(0).getRank() == 13; // can only add a king to an empty stack
        } else {
            Card lastCard = cards.get(cards.size() - 1);
            Card firstNewCard = newCards.get(0);
            return lastCard.isOneRankLowerAndOppositeColor(firstNewCard);
        }
    }
}
