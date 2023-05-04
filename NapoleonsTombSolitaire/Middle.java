import java.util.ArrayList;
import java.util.List;

public class Middle extends CardStack {
    private int middleNumber;
    
    public Middle(int middleNumber) {
        super();
        this.middleNumber = middleNumber;
    }
    
    public int getMiddleNumber() {
        return middleNumber;
    }

    public Card removeCard() {
        return cards.remove(cards.size() - 1);
    }
    
    
    @Override
    public boolean canAddCard(Card card) {
        if (isEmpty()) {
            return card.getRank() == 6;
        } else {
            List<Card> topCards = getTopCards(1);
            Card topCard = topCards.get(0);
            return (card.getRank() == topCard.getRank() + 1 && card.getSuit().equals(topCard.getSuit()));
        }
    }
    
    
    
    public boolean canRemoveCards(int count) {
        return size() >= count;
    }
    
    public List<Card> removeCards(int count) {
        List<Card> removedCards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            removedCards.add(removeCard());
        }
        return removedCards;
    }

    @Override
    public Card getTopCard() {
        return isEmpty() ? null : cards.get(cards.size() - 1);
    }

}
