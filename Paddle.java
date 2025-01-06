package pong;
import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {
    int id;
    int yVelocity;
    int speed = 10;

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1: // Player 1 controls
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                }
                break;
            case 2: // Player 2 controls
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                }
                break;
        }
    }

    public void move() {
        y += yVelocity;
        // Prevent the paddle from going out of bounds
        if (y < 0) {
            y = 0;
        }
        if (y > pongPanel.GAME_HEIGHT - height) { // Assuming GAME_HEIGHT is a static variable in PongPanel
            y = pongPanel.GAME_HEIGHT - height;
        }
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void draw(Graphics g) {
        if(id == 1) {
            g.setColor(Color.blue);
        }
        if(id == 2) {
            g.setColor(Color.red);
        }
        g.fillRect(x, y, width, height);
    }
}
