
//Vasilevskij Timofey
//26042018
//SuperBestGame

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Main {
	static Level level1;

	public static void main(String[] args) throws Exception {
		level1 = new Level("level.txt");
		JFrame window = new JFrame("jump and bump");
		window.setSize(level1.w, level1.h);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel Game2 = new MyPanel();
		window.add(Game2);
		Game2.setFocusable(true);
		window.setVisible(true);

		Game2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				for (int i = 0; i < level1.rabbits.length; i++) {
					level1.rabbits[i].keyreleased(arg0.getKeyCode());
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				for (int i = 0; i < level1.rabbits.length; i++) {
					level1.rabbits[i].keypressed(arg0.getKeyCode());
				}

			}
		});
		Timer T = new Timer(16, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < level1.rabbits.length; i++) {
					level1.rabbits[i].update();
				}
				window.repaint();
			}
		});
		T.start();
	}

}
