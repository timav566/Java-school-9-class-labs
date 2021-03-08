
//Vasilevskij Timofey
//26042018
//SuperBestGame

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Graphics2D;
import javax.swing.*;

class Level implements Drawable {
	Wall[] walls;
	Rabbit[] rabbits;
	Drawable[] drawables;
	Hittable[] hittables;
	static final int w = 700;
	static final int h = 700;
	static final int R = 40;

	Level(String filename) throws IOException {
		Scanner sc = new Scanner(new File(filename));
		int n = sc.nextInt();
		walls = new Wall[n];
		for (int i = 0; i < n; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int W = sc.nextInt();
			int H = sc.nextInt();
			walls[i] = new Wall(X, Y, W, H, new File("wall-2918858_960_720.jpg"));
		}
		int k = sc.nextInt();
		rabbits = new Rabbit[k];
		drawables = new Drawable[n + k + 1];
		drawables[0] = new Background(this);
		hittables = new Hittable[n + k];
		for (int i = 0; i < n; i++) {
			drawables[i + 1] = walls[i];
			hittables[i] = walls[i];
		}

		for (int i = n; i < n + k; i++) {
			int X = (int) (Math.random() * w);
			int Y = (int) (Math.random() * h);
			int keyleft = sc.nextInt();
			int keyright = sc.nextInt();
			int keyup = sc.nextInt();
			rabbits[i - n] = new Rabbit(X, Y, R, keyleft, keyright, keyup, new File("0_64e7d_857a3ad1_L.png"));
			drawables[i + 1] = rabbits[i - n];
			hittables[i] = rabbits[i - n];
		}
	}

	public void draw(Graphics2D g2d) {
		for (Drawable drawable : drawables) {
			drawable.draw(g2d);
		}
	}
}

class MyPanel extends JPanel {
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D g2d = (Graphics2D) arg0;
		Main.level1.draw(g2d);
	}
}
