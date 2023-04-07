public class KingStack extends CardStack {
    private String suit;
    
    public KingStack(String suit) {
        super();
        this.suit = suit;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public boolean canAddCard(Card card) {
        if (isEmpty()) {
            return card.getRank() == 13;
        } else {
            return false;
        }
    }
    
    public boolean canRemoveCard() {
        return !isEmpty();
    }
}
