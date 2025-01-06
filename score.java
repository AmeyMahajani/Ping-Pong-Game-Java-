package pong;

import java.awt.*;

public class score extends Rectangle {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;

    score(int GAME_WIDTH, int GAME_HEIGHT) {
        score.GAME_WIDTH = GAME_WIDTH;
        score.GAME_HEIGHT = GAME_HEIGHT;
        player1 = 0;
        player2 = 0;
    }

    // Method to increment player scores
    public void increasePlayer1Score() {
        player1++;
    }

    public void increasePlayer2Score() {
        player2++;
    }

    // Method to draw the score on the screen
    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.setFont(new Font("Consolas", Font.PLAIN, 60));
        g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);

        // Display scores
        g.drawString(String.valueOf(player1), (GAME_WIDTH / 4), 60); // Player 1 score
        g.drawString(String.valueOf(player2), (3 * GAME_WIDTH / 4), 60); // Player 2 score
    }
}
