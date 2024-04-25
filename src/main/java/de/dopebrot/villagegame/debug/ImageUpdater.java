package de.dopebrot.villagegame.debug;
import javax.swing.*;
import java.awt.*;

public class ImageUpdater extends JFrame {

	Canvas canvas;
	Graphics graphics;
	public ImageUpdater(String title) {
		setTitle(title);
		setSize((int) (800f * 0.9f), (int) (800f * 0.9f));
		this.canvas = new Canvas();
		this.graphics = this.getGraphics();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.setBackground(Color.DARK_GRAY);
		getContentPane().add(this.canvas, BorderLayout.CENTER);
		setVisible(true);
		setResizable(false);
	}

	public void draw(int x, int y, Color color) {
		Graphics graphics1 = canvas.getGraphics();
		graphics1.setColor(color);
		graphics1.fillRect(x, y, 1, 1);
	}

	public void clear() {
		graphics.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
	}

}
