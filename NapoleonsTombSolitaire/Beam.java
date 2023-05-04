import java.util.ArrayList;
import java.util.List;

public class Beam extends CardStack {
    private int beamNumber;

    public Beam(int beamNumber) {
        super();
        this.beamNumber = beamNumber;
    }

    public int getBeamNumber() {
        return beamNumber;
    }

    @Override
    public boolean canAddCard(Card card) {
        if (isEmpty()) {
            return card.getRank() == 7;
        } else {
            Card topCard = getTopCard();
            return (card.getRank() == topCard.getRank() + 1 && !card.getSuit().equals(topCard.getSuit()));
        }
    }

    @Override
    public boolean canRemoveCards(int count) {
        return size() >= count;
    }

    @Override
    public Card getTopCard() {
        if (isEmpty()) {
            return null;
        } else {
            return cards.get(size() - 1);
        }
    }

    @Override
    public Card removeCard() {
        if (isEmpty()) {
            return null;
        } else {
            return cards.remove(size() - 1);
        }
    }

    @Override
    public List<Card> removeCards(int count) {
        List<Card> removedCards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            removedCards.add(removeCard());
        }
        return removedCards;
    }
}

public class Middle extends CardStack {
    private int middleNumber;

    public Middle(int middleNumber) {
        super();
        this.middleNumber = middleNumber;
    }

    public int getMiddleNumber() {
        return middleNumber;
    }

    @Override
    public boolean canAddCard(Card card) {
        if (isEmpty()) {
            return card.getRank() == 6;
        } else {
            Card topCard = getTopCard();
            return (card.getRank() == topCard.getRank() + 1 && !card.getSuit().equals(topCard.getSuit()));
        }
    }

    @Override
    public boolean canRemoveCards(int count) {
        return size() >= count;
    }

    @Override
    public Card removeCard() {
        return cards.remove(cards.size() - 1);
    }

    @Override
    public List<Card> removeCards(int count) {
        List<Card> removedCards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            removedCards.add(removeCard());
        }
        return removedCards;
    }
}
