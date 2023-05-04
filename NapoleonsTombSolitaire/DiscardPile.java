import java.util.Stack;

public class DiscardPile extends CardStack {
    private Stack<Card> pile;
    
    public DiscardPile() {
        super();
        pile = new Stack<>();
    }
    
    public void addCard(Card card) {
        pile.push(card);
    }
    
    public Card removeCard() {
        return pile.pop();
    }
    
    public boolean canRemoveCard() {
        return !pile.isEmpty();
    }

    public void clear() {
        cards.clear();
    }

    @Override
    public boolean canAddCard(Card card) {
        return this.isEmpty() || this.getTopCard().isOneRankHigherAndOppositeColor(card);
    }

    @Override
    public Card getTopCard() {
        if (cards.isEmpty()) {
            return null;
        } else {
            return cards.get(cards.size() - 1);
        }
    }
    
}
