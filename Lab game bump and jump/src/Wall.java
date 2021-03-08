
//Vasilevskij Timofey
//26042018
//SuperBestGame

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Wall extends Hittable implements Drawable {
	static BufferedImage wall;

	Wall(int X, int Y, int W, int H, File B) throws IOException {
		x = X;
		y = Y;
		w = W;
		h = H;
		wall = ImageIO.read(B);
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(wall, x, y, x + w, y + h, 0, 0, w, h, null);
	}
}