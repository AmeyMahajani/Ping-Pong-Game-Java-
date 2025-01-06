package pong;
import java.awt.*;

import javax.swing.JFrame;



public class pongFrame extends JFrame{
	pongPanel panel ;
	
	pongFrame(){
	panel =new pongPanel();
	this.add(panel);
	this.setTitle("Pong Game");
	this.setResizable(false);
	this.setBackground(Color.black);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
	this.setVisible(true);
	this.setLocationRelativeTo(null);
	
	
	}
}
