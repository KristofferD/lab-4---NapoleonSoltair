import java.util.ArrayList;
import java.util.List;


public class GameBoardController {
    private GameBoard gameBoard;

    public GameBoardController(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public boolean isGameOver() {
        // Add code to check if the game is over
        return false;
    }

    public boolean moveCard(Card card, CardStack fromStack, CardStack toStack) {
        if (toStack.canAddCard(card)) {
            List<Card> cardsToRemove = fromStack.getTopCards(fromStack.size() - fromStack.getCards().indexOf(card));
            if (fromStack.removeCards(cardsToRemove.size()).equals(cardsToRemove)) {
                toStack.addCard(card);
                return true;
            } else {
                fromStack.addCards(cardsToRemove);
                return false;
            }
        } else {
            return false;
        }
    }
}
