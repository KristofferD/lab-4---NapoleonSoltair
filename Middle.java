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
    
    public boolean canAddCard(Card card) {
        if (isEmpty()) {
            return (card.getRank() == 6 || card.getRank() == 1);
        } else {
            Card topCard = getTopCard();
            return ((card.getRank() == topCard.getRank() - 1 && card.getColor() != topCard.getColor())
                    || (card.getRank() == 1 && topCard.getRank() == 6));
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
}
