import javax.swing.JFrame;

public class NapoleonsTombSolitaire {
    public static void main(String[] args) {
        // Create a new deck of cards
        Deck deck = new Deck();
        deck.shuffle();
        
        // Create a new game board with the shuffled deck
        GameBoard board = new GameBoard(deck);
        
        // Create a new game controller to manage the game logic
        GameController controller = new GameController(board);
        
        // Create a new graphical user interface for the game
        GameGUI gui = new GameGUI(controller);
        
        // Set up the main window for the game
        JFrame frame = new JFrame("Napoleon's Tomb Solitaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gui);
        frame.pack();
        frame.setVisible(true);
    }
}
