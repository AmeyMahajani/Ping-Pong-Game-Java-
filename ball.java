package pong;

import java.awt.*;
import java.util.Random;

public class ball extends Rectangle {
    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 3;

    ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random();

        // Random X Direction
        int randomXDirection = random.nextInt(2) == 0 ? -1 : 1;
        setXDirection(randomXDirection * initialSpeed);

        // Random Y Direction
        int randomYDirection = random.nextInt(2) == 0 ? -1 : 1;
        setYDirection(randomYDirection * initialSpeed);
    }

    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, width, height); // Use x and y for position
    }
}
