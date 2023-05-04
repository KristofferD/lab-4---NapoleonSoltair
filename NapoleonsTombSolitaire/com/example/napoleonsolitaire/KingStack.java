package com.example.napoleonsolitaire;


public class KingStack extends CardStack {
    private String suit;
    
    public KingStack(String suit) {
        super();
        this.suit = suit;
    }
    
    public String getSuit() {
        return suit;
    }
    
    @Override
    public boolean canAddCard(Card card) {
        if (isEmpty()) {
            return card.getRank() == 13 && card.getSuit().equals(suit);
        } else {
            return false;
        }
    }
    
    public boolean canRemoveCard() {
        return !isEmpty();
    }

    public Card getTopCard() {
        if (cards.isEmpty()) {
            return null;
        } else {
            return cards.get(cards.size() - 1);
        }
    }
}
