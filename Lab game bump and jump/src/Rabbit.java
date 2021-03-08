
//Vasilevskij Timofey
//26042018
//SuperBestGame

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Rabbit extends Hittable implements Drawable {
	static final int vx1 = -3;
	static final int vx2 = -vx1;
	static final int vy1 = -14;
	static final double g = 0.3;
	static final int d = 20;
	static final int X = 200;
	static final int Y = 30;
	static BufferedImage rabbit;
	static final Color c = Color.green;
	double vx;
	double vy;
	int r;
	int keyLeft, keyRight, keyUp;
	boolean pushedUp = false;
	boolean pushedDown = false;
	boolean pushedLeft = false;
	boolean pushedRight = false;
	static int nCreatedRabbits = 0;
	Score score = new Score(Main.level1, X + X * nCreatedRabbits, Y);

	Rabbit(int X, int Y, int R, int left, int right, int up, File Image) throws IOException {
		nCreatedRabbits++;
		x = X;
		y = Y;
		r = R;
		h = R;
		w = R;
		rabbit = ImageIO.read(Image);
		keyLeft = left;
		keyRight = right;
		keyUp = up;
	}

	public void keypressed(int Key) {
		if ((Key == keyLeft) && (pushedLeft == false)) {
			vx = vx1;
		}
		if ((Key == keyRight) && (pushedRight == false)) {
			vx = vx2;
		}
		if ((Key == keyUp) && pushedDown == true) {
			vy = vy1;
		}
	}

	public void keyreleased(int key) {
		if (key == keyLeft || key == keyRight) {
			vx = 0;
		}
	}

	public void update() {
		pushedUp = false;
		pushedLeft = false;
		pushedDown = false;
		pushedRight = false;
		for (int i = 0; i < Main.level1.hittables.length; i++) {
			if (Main.level1.hittables[i] != this) {
				if ((Main.level1.hittables[i].hitTest(x, y, r) == Hittable.south) || (y >= Level.h - d - r)) {
					pushedDown = true;
				}
				if (((Main.level1.hittables[i].hitTest(x, y, r) == Hittable.west)) || x <= 0) {
					pushedLeft = true;
				}
				if ((Main.level1.hittables[i].hitTest(x, y, r) == Hittable.north)) {
					if (Main.level1.hittables[i].getClass() == Rabbit.class)
						score.updateScore(1);
					pushedUp = true;
				} else if (y < 0) {
					pushedUp = true;
				}
				if (((Main.level1.hittables[i].hitTest(x, y, r) == Hittable.east) || (x > Level.w - r))) {
					pushedRight = true;
				}
			}
		}
		if (((pushedDown == true) && vy > 0)) {
			vy = 0;
		} else {
			vy += g;
			y += vy;
		}
		if (pushedUp == true && vy < 0) {
			vy = 0;
		}
		if ((pushedLeft == true && vx < 0) || (pushedRight == true && vx > 0)) {
			vx = 0;
		}
		x += vx;
		if (pushedUp == true && pushedDown == true) {
			x = X;
			y = X;
		}
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(rabbit, x - r / 2, y - r / 2, r, r, null);
		g2d.setColor(Color.BLACK);
		score.draw(g2d);
	}
}
