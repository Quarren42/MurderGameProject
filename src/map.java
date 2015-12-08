import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class map extends JFrame {
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static double width = screenSize.getWidth();
	static double height = screenSize.getHeight();
	
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

	private static final String P1_MOVE_UP = "p1 up";
	private static final String P1_MOVE_DOWN = "p1 down";
	private static final String P1_MOVE_LEFT = "p1 left";
	private static final String P1_MOVE_RIGHT = "p1 right";

	private static final String P2_MOVE_UP = "p2 up";
	private static final String P2_MOVE_DOWN = "p2 down";
	private static final String P2_MOVE_LEFT = "p2 left";
	private static final String P2_MOVE_RIGHT = "p2 right";
	
	private static final String SWAP_ICONS = "swap icons";

	static JLabel obj1 = new JLabel();

	static List<List<Integer>> level = new ArrayList<List<Integer>>() {
		{
			add(Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4));
			add(Arrays.asList(4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 4, 4, 0, 4, 4, 0, 0, 0, 4, 4, 4, 4, 4, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 4, 4, 0, 4, 4, 0, 0, 0, 4, 4, 4, 4, 4, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 4, 4, 0, 4, 4, 0, 0, 0, 4, 4, 4, 4, 4, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 4, 4, 4, 4, 4, 0, 0, 0, 4, 4, 0, 4, 4, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4));
			add(Arrays.asList(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4));
			add(Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4));
			
		}
	};

	int p1x = 1;
	int p1y = 1;

	int p2x = 19; //grid size -2
	int p2y = 19;

	int prev_p1x;
	int prev_p1y;

	int prev_p2x;
	int prev_p2y;

	public map() {

		super("level");
		setContentPane(new DrawPane());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize((int)height, (int)height); //make game in square window
		setLayout(new BorderLayout());
		setVisible(true);
		
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), P1_MOVE_UP);
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), P1_MOVE_DOWN);
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("A"), P1_MOVE_LEFT);
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), P1_MOVE_RIGHT);

		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), P2_MOVE_UP);
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), P2_MOVE_DOWN);
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), P2_MOVE_LEFT);
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), P2_MOVE_RIGHT);
		
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("P"), SWAP_ICONS);

		obj1.getActionMap().put(P1_MOVE_UP, new p1_MoveAction(0, 1));
		obj1.getActionMap().put(P1_MOVE_DOWN, new p1_MoveAction(0, -1));
		obj1.getActionMap().put(P1_MOVE_LEFT, new p1_MoveAction(-1, 0));
		obj1.getActionMap().put(P1_MOVE_RIGHT, new p1_MoveAction(1, 0));

		obj1.getActionMap().put(P2_MOVE_UP, new p2_MoveAction(0, 1));
		obj1.getActionMap().put(P2_MOVE_DOWN, new p2_MoveAction(0, -1));
		obj1.getActionMap().put(P2_MOVE_LEFT, new p2_MoveAction(-1, 0));
		obj1.getActionMap().put(P2_MOVE_RIGHT, new p2_MoveAction(1, 0));
		
		obj1.getActionMap().put(SWAP_ICONS, new swapIcons());

		add(obj1);
	}

	public void print() {

		for (int i = 0; i < level.size(); i++) {
			List<Integer> result = this.level.get(i);
			System.out.println(result);
		}
		System.out.println("\n");
	}

	private class p1_MoveAction extends AbstractAction {

		int x;
		int y;

		p1_MoveAction(int x, int y) {

			this.x = x;
			this.y = y;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			prev_p1x = p1x;
			prev_p1y = p1y;

			p1x = p1x + x;
			p1y = p1y + y * -1; // make negative because down is considered a
								// higher value

			int p1value = level.get(p1y).get(p1x); // get the value of the new
													// index

			if (p1value == 2) {
				DrawPane.playerKill = 2;
				DrawPane.transparency = 0;
				level.get(prev_p1y).set(prev_p1x, Integer.valueOf(3));

			} else {

				if (p1value == 4) {
					p1x = prev_p1x; // revert player to previous position
					p1y = prev_p1y;
				}

				else {
					level.get(p1y).set(p1x, Integer.valueOf(1));
					// set new p1 position

					level.get(prev_p1y).set(prev_p1x, Integer.valueOf(0));
					// erase old p1 position
				}
			}
		}
	}

	private class p2_MoveAction extends AbstractAction {

		int x;
		int y;

		p2_MoveAction(int x, int y) {

			this.x = x;
			this.y = y;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			prev_p2x = p2x;
			prev_p2y = p2y;

			p2x = p2x + x;
			p2y = p2y + y * -1;

			int p2value = level.get(p2y).get(p2x);

			if (p2value == 1) {
				DrawPane.playerKill = 1;
				DrawPane.transparency = 0;
				level.get(p2y).set(p2x, Integer.valueOf(3));
			}

			else {
				if (p2value == 4) {
					p2x = prev_p2x; // revert player to previous position
					p2y = prev_p2y;
				}

				else {
					level.get(p2y).set(p2x, Integer.valueOf(2));
					level.get(prev_p2y).set(prev_p2x, Integer.valueOf(0));
				}
			}
		}
	}
	
	private class swapIcons extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (DrawPane.iconsFlipped == false){
				DrawPane.iconsFlipped = true;
			} else {
				DrawPane.iconsFlipped = false;
			}
		}	
	}
	
	public static int getValue(int i, int j) {
		int returnValue;
		returnValue = level.get(i).get(j);
		return returnValue;
	}
}
