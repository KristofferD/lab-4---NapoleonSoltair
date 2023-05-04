import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;

public class GamePanel extends JPanel {
    private NapoleonsTombSolitaire game;

    public GamePanel(NapoleonsTombSolitaire game) {
        this.game = game;
    }    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 50;
        int width = 120;
        int height = 160;
        int padding = 30;
        int stackCount = 4;

        // Draw the card stacks
        for (int i = 0; i < stackCount; i++) {
            // Draw the card stack background
            g.setColor(Color.WHITE);
            g.fillRect(x, y, width, height);

            // Draw the card backs
            int numCards = game.getBeamStacks().get(i).size();
            int cardY = y + padding;
            for (int j = 0; j < numCards; j++) {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x + padding * j, cardY, width - padding * j, height - cardY);
                g.setColor(Color.BLACK);
                g.drawRect(x + padding * j, cardY, width - padding * j, height - cardY);
            }

            // Draw the top card of the beam
            List<Card> topCards = game.getBeamStacks().get(i).getTopCards(1);
            if (topCards != null && !topCards.isEmpty()) {
                Card topCard = topCards.get(0);
                g.drawImage(topCard.getCardImage(), x, y, this);
            }
            

            

            // Draw the card stack border
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);

            // Move to the next card stack
            x += width + padding;
        }
    }
}
