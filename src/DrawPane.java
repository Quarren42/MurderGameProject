import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawPane extends JPanel {

	int size = map.level.size();
	int gridHeight = (int) (map.height / size);
	int gridWidth = (int) (map.width / size);

	static boolean iconsFlipped = false;
	static float transparency;
	static int playerKill = 0;

	private BufferedImage pacman;
	private BufferedImage albert;
	private BufferedImage vick;
	private BufferedImage vikas;
	private BufferedImage blood;
	private BufferedImage brick;

	public DrawPane() {
		try {
			pacman = ImageIO.read(ClassLoader.getSystemResource("resources/pacman.png"));
			albert = ImageIO.read(ClassLoader.getSystemResource("resources/albert.png"));
			vick = ImageIO.read(ClassLoader.getSystemResource("resources/vick.png"));
			vikas = ImageIO.read(ClassLoader.getSystemResource("resources/vikas.png"));
			blood = ImageIO.read(ClassLoader.getSystemResource("resources/blood.png"));
			brick = ImageIO.read(ClassLoader.getSystemResource("resources/brick.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		// draw on g here e.g.

		Color fadeBlack = new Color(0, 0, 0, transparency);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				int mapValue = map.getValue(j, i);

				if (iconsFlipped == true) {

					switch (mapValue) {

					case 0:
						g.setColor(Color.white);
						g.fillRect(i * gridHeight, j * gridHeight, gridHeight, gridHeight);
						break;

					case 1:
						g.drawImage(albert, i * gridHeight, j * gridHeight, gridHeight, gridHeight, Color.white, null);
						break;

					case 2:
						g.drawImage(vikas, i * gridHeight, j * gridHeight, gridHeight, gridHeight, Color.white, null);
						break;

					case 3:
						g.drawImage(blood, i * gridHeight, j * gridHeight, gridHeight, gridHeight, Color.white, null);
						break;
						
					case 4:
						g.setColor(Color.black);
						g.drawImage(vick, i * gridHeight, j * gridHeight, gridHeight, gridHeight, Color.white, null);
						break;

					}
				} else {

					switch (mapValue) {

					case 0:
						g.setColor(Color.white);
						g.fillRect(i * gridHeight, j * gridHeight, gridHeight, gridHeight);
						break;

					case 1:
						g.setColor(Color.blue);
						g.fillRect(i * gridHeight, j * gridHeight, gridHeight, gridHeight);
						break;

					case 2:
						g.setColor(Color.red);
						g.fillRect(i * gridHeight, j * gridHeight, gridHeight, gridHeight);
						break;

					case 3:
						g.drawImage(blood, i * gridHeight, j * gridHeight, gridHeight, gridHeight, Color.white, null);
						break;

					case 4:
						g.setColor(Color.black);
						g.fillRect(i * gridHeight, j * gridHeight, gridHeight, gridHeight);

						break;
					}
				}
			}
		}

		switch (playerKill) {

		case 0:
			g.setColor(fadeBlack);
			g.fillRect(0, 0, (int) map.height, (int) map.height);
			repaint();
			break;

		case 1:
			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.PLAIN, 30));
			g.drawString("Player 1 was killed! The murderer caught up to you.",
					gridHeight * 3, (int) (map.height / 2));
			break;

		case 2:
			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.PLAIN, 30));
			g.drawString("Player 1 was killed! You ran into the murderer.",
					gridHeight * 3, (int) (map.height / 2));
			break;
		}
	}
}