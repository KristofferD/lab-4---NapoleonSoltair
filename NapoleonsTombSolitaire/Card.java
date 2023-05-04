public class Card {
    private String suit;
    private int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String getColor() {
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds")) {
            return "red";
        } else {
            return "black";
        }
    }

    public boolean isOneRankLowerAndOppositeColor(Card card) {
        return card.getRank() == this.getRank() - 1 && !card.getColor().equals(this.getColor());
    }
    

    @Override
    public String toString() {
        String rankString;
        switch (rank) {
            case 1:
                rankString = "Ace";
                break;
            case 11:
                rankString = "Jack";
                break;
            case 12:
                rankString = "Queen";
                break;
            case 13:
                rankString = "King";
                break;
            default:
                rankString = Integer.toString(rank);
                break;
        }
        return rankString + " of " + suit;
    }
}
