import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Graphics;

public class NapoleonsTombSolitaire {
    public static void main(String[] args) {
        // Create a new deck of cards
        Deck deck;
        if (args.length > 0) {
            try {
                long seed = Long.parseLong(args[0]);
                deck = new Deck(seed);
            } catch (NumberFormatException e) {
                System.err.println("Invalid seed value provided. Using a random seed instead.");
                deck = new Deck();
            }
        } else {
            deck = new Deck();
        }

        String seedMessage;
        long seed = deck.getSeed();
        if (seed != 0L) {
            seedMessage = "The game seed is: " + seed;
        } else {
            seedMessage = "The game is using a random seed.";
        }


        JOptionPane.showMessageDialog(null, seedMessage, "Game Seed", JOptionPane.INFORMATION_MESSAGE);

        // Create a new game board with the shuffled deck
        GameBoard board = new GameBoard(deck);

        // Create a new game controller to manage the game logic
        GameBoardController controller = new GameBoardController(board);

        // Create a new graphical user interface for the game
        JPanel gamePanel = new GamePanel(controller);
        gamePanel.setPreferredSize(new Dimension(1920, 1080));

        // Set up the main window for the game
        JFrame frame = new JFrame("Napoleon's Tomb Solitaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.setSize(1920, 1080);

        // Add the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenuItem restartMenuItem = new JMenuItem("Restart");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        restartMenuItem.addActionListener(e -> {
            // Code to restart the game
        });

        exitMenuItem.addActionListener(e -> {
            System.exit(0);
        });

        gameMenu.add(restartMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }
}
