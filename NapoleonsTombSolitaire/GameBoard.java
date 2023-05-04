import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private Deck deck;
    private DiscardPile discardPile;
    private List<Beam> beams;
    private List<Middle> middles;
    private List<KingStack> kingStacks;
    private List<Card> cards;



    public GameBoard(Deck deck) {
        this.deck = deck;
        this.discardPile = new DiscardPile();
        this.beams = new ArrayList<>();
        this.middles = new ArrayList<>();
        this.kingStacks = new ArrayList<>();

        // Create and initialize the beams
        for (int i = 0; i < 4; i++) {
            beams.add(new Beam(i));
        }

        // Create and initialize the middles
        for (int i = 0; i < 4; i++) {
            middles.add(new Middle(i));
        }

        // Create and initialize the king stacks
        kingStacks.add(new KingStack("Spades"));
        kingStacks.add(new KingStack("Hearts"));
        kingStacks.add(new KingStack("Diamonds"));
        kingStacks.add(new KingStack("Clubs"));
    }

    public Deck getDeck() {
        return deck;
    }

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    public List<Beam> getBeams() {
        return beams;
    }

    public List<Middle> getMiddles() {
        return middles;
    }

    public List<KingStack> getKingStacks() {
        return kingStacks;
    }

    public boolean isGameOver() {
        // The game is over if all the king stacks are full
        for (KingStack kingStack : kingStacks) {
            if (!kingStack.canRemoveCard()) {
                return false;
            }
        }
        return true;
    }

    public void deal() {
        if (deck.isEmpty()) {
           
            deck = discardPile.toDeck();
            deck.shuffle();
            discardPile.clear();
        }
        Card card = deck.dealCard();
        discardPile.addCard(card);
    }

    public boolean isValidMove(Card card, CardStack stack) {
        // Check if the card can be added to the stack
        if (!stack.canAddCard(card)) {
            return false;
        }

        // Check if the move is valid based on the type of stack
        if (stack instanceof Beam) {
            Beam beam = (Beam) stack;
            if (card.getRank() == 6) {
                // Check if the card can be added to the middle column
                for (Middle middle : middles) {
                    if (middle.canAddCard(card)) {
                        return true;
                    }
                }
                return false;
            } else if (card.getRank() == 7) {
                // Check if the card can be added to another beam
                for (Beam otherBeam : beams) {
                    if (otherBeam != beam && otherBeam.canAddCard(card)) {
                        return true;
                    }
                }
                return false;
            } else {
                return true;
            }
        } else if (stack instanceof Middle) {
            Middle middle = (Middle) stack;
            if (card.getRank() == 6) {
                // Check if the card can be added to the middle column
                for (Middle otherMiddle : middles) {
                    if (otherMiddle != middle && otherMiddle.canAddCard(card)) {
                        return true;
                    }
                }
                return false;
            } else {
                return true;
            }
        } else if (stack instanceof KingStack) {
            KingStack kingStack = (KingStack) stack;
            if (card.getRank() == 13 && kingStack.isEmpty()) {
                return true;
            } else if (kingStack.isEmpty()) {
                return false;
            } else {
                Card topCard = kingStack.getTopCard();
                if (card.getSuit().equals(topCard.getSuit()) && card.getRank() == topCard.getRank() - 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean canRemoveCards(CardStack stack, int count) {
        return stack.canRemoveCards(count);
    }

    public List<Card> removeCards(CardStack stack, int count) {
        return stack.removeCards(count);
    }

    public boolean canMoveCards(CardStack source, CardStack target, int count) {
        List<Card> cards = source.getTopCards(count);
        if (cards == null) {
            return false;
        }
        for (Card card : cards) {
            if (!target.canAddCard(card)) {
                return false;
            }
        }
        return true;
    }

    public void moveCards(CardStack source, CardStack target, int count) {
        List<Card> cards = source.getTopCards(count);
        if (cards == null) {
            throw new IllegalArgumentException("Not enough cards to move");
        }
        if (!target.canAddCards(cards)) {
            throw new IllegalArgumentException("Invalid move");
        }
        for (Card card : cards) {
            target.addCard(card);
        }
        source.removeCards(count);
    }

    public Deck toDeck() {
        Deck deck = new Deck();
        deck.addCards(this.cards);
        return deck;
    }
    
    public boolean canAddCard(Card card, CardStack stack) {
        return stack.canAddCard(card);
    }
    
}
