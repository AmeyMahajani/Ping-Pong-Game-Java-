# Ping-Pong-Game-Java-

### **1. Game Frame (Main Class)**

This is the class that runs the code and sets up the game window. It creates the JFrame where the game will be displayed, and it initializes the `pongPanel` where the actual gameplay happens.

- **Purpose**: To create the game window and initialize the `pongPanel` (where the game takes place).
- **Attributes**:
  - The window size, title, visibility, and close behavior are set here.
  - **`setResizable(false)`**: The window cannot be resized.
  - **`setLocationRelativeTo(null)`**: Centers the window on the screen.
  - **`setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)`**: Ensures the game window closes when the user clicks the close button.
- **Functionality**:
  - This class doesn’t handle any game logic itself. It simply creates the window, sets the game panel, and starts the game by calling `pack()` to size the frame and `setVisible(true)` to make the frame visible.

```java
public class PongGame extends JFrame {
    public PongGame() {
        this.setTitle("Pong Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(new pongPanel()); // Add the game panel (where the game happens)
        this.pack(); // Fit the window to the panel size
        this.setVisible(true); // Show the window
    }

    public static void main(String[] args) {
        new PongGame(); // Start the game by creating the frame
    }
}
```

---

### **2. pongPanel (Game Panel)**

This is the class where the game logic happens. It extends `JPanel` and implements `Runnable` to manage the game loop. The `pongPanel` manages the game objects (paddles, ball) and updates the screen.

- **Purpose**: To handle the game’s main functionality: rendering, movement, collision, and the game loop.
- **Attributes**:
  - **`gameThread`**: This `Thread` object runs the game loop by executing the `run()` method.
  - **`image` and `graphics`**: These are used for double buffering. The `image` is an off-screen image where all the game elements are drawn, and then it’s drawn to the screen to avoid flickering.
  - **`paddle1, paddle2`**: These represent the two paddles controlled by the players.
  - **`ball`**: This represents the ball that moves around the screen.
  - **`score`**: This tracks the score of both players.
  
**Key Methods**:
- **`newBall()`**: Initializes the ball at the center of the screen.
- **`newPaddle()`**: Initializes two paddles, one for each player.
- **`paint(Graphics g)`**: Handles the rendering by drawing everything to the screen using double buffering. The `draw()` method is called to draw the paddles, ball, and score.
- **`draw(Graphics g)`**: Draws the paddles, ball, and score.
- **`move()`**: Moves the paddles and ball by calling their respective move methods.
- **`checkCollision()`**: Checks for collisions between the ball and the paddles or walls. Updates the game state by bouncing the ball or updating the score.
- **`run()`**: The game loop, which updates the game 60 times per second (60 ticks per second). It moves the ball, checks for collisions, and re-renders the screen.

```java
public class pongPanel extends JPanel implements Runnable {
    // Class initialization and game logic goes here
}
```

---

### **3. Paddle Class**

The `Paddle` class represents the paddles controlled by the two players. It extends `Rectangle`, which gives it a position and size, making collision detection easier.

- **Purpose**: To manage the paddles' movement and interaction with the ball.
- **Attributes**:
  - **`x, y`**: Position of the paddle.
  - **`width, height`**: Dimensions of the paddle.
  - **`id`**: Identifies whether the paddle is for Player 1 or Player 2.
  - **`yVelocity`**: Controls the speed of the paddle’s vertical movement.

**Key Methods**:
- **`keyPressed(KeyEvent e)`**: Handles key presses to control the paddle movement. If a key like 'W' or 'S' is pressed, the paddle moves up or down.
- **`keyReleased(KeyEvent e)`**: Stops the paddle’s movement when the key is released.
- **`move()`**: Updates the paddle’s vertical position based on its velocity, ensuring it doesn’t go out of bounds.
- **`draw(Graphics g)`**: Draws the paddle on the screen.

```java
public class Paddle extends Rectangle {
    // Class initialization and movement handling goes here
}
```

---

### **4. Ball Class**

The `ball` class extends `Rectangle`, making it easy to manage the ball’s position and handle collisions.

- **Purpose**: To manage the ball’s movement and interaction with the paddles and walls.
- **Attributes**:
  - **`x, y`**: Position of the ball on the screen.
  - **`xVelocity, yVelocity`**: The speed at which the ball moves horizontally and vertically.
  
**Key Methods**:
- **`setXDirection(int xDirection)`**: Sets the ball’s horizontal direction.
- **`setYDirection(int yDirection)`**: Sets the ball’s vertical direction.
- **`move()`**: Updates the ball’s position and checks for collisions with the walls (bouncing off the top and bottom).
- **`draw(Graphics g)`**: Draws the ball on the screen.

```java
public class ball extends Rectangle {
    // Ball movement and drawing logic goes here
}
```

---

### **5. Score Class**

The `score` class keeps track of the score for both players. It displays the score on the screen and updates it when a player scores a point.

- **Purpose**: Tracks and displays the score for both players.
- **Attributes**:
  - **`player1, player2`**: The score of each player.
  - **`GAME_WIDTH, GAME_HEIGHT`**: Used to position the score text on the screen.
  
**Key Methods**:
- **`draw(Graphics g)`**: Draws the score for both players at the top center of the screen.

```java
public class score {
    // Initialization and score logic goes here
}
```

---

### **6. AL (KeyListener)**

The `AL` class is a key adapter that listens for key events and handles paddle movement accordingly.

- **Purpose**: Responds to key events to control the paddles.
  
**Key Methods**:
- **`keyPressed(KeyEvent e)`**: Moves the paddles when keys are pressed.
- **`keyReleased(KeyEvent e)`**: Stops the paddle movement when keys are released.

```java
public class AL extends KeyAdapter {
    // Paddle control logic goes here
}
```

---

### **Summary of the Workflow**:

- **Game Frame**: Sets up the window and initializes the `pongPanel`.
- **`pongPanel`**: Handles the game loop, drawing, and logic, including movement, collision, and score management.
- **Paddle and Ball**: These classes represent the game elements (paddles and ball) and their interactions.
- **Score**: Keeps track of the players’ scores and displays them on the screen.
- **KeyListener (AL)**: Listens for user input to move the paddles.

