import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Score implements Drawable {
	Level theLevel;
	int score = 0;
	int x, y;

	Score(Level theLevel, int x, int y) {
		this.theLevel = theLevel;
		this.x = x;
		this.y = y;
	}

	void updateScore(int points) {
		score += points;
	}

	public void draw(Graphics2D g2d) {
		String scoreS = Integer.toString(score);
		g2d.drawString(scoreS, x, y);
	}
}
