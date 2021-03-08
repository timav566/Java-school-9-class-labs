import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.util.*;
import javax.swing.*;

class Background implements Drawable {
	Level theLevel;

	Background(Level theLevel) {
		this.theLevel = theLevel;
	}

	public void draw(Graphics2D g2d) {
		int width = theLevel.w;
		int height = theLevel.h;
		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 0, width, height);
	}
}
