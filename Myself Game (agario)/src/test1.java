import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.Timer;
import javax.*;

public class test1 {
	Timer t;
	double x, y, vx, vy;
	double x1, y1;
	double V;
	int mx, my;
	public int[] arr;
	int r, R1, R2, R3;
	int[] X, Y, state;
	int W, H;
	int EX, EY;
	int r5 = 20;
	int win;
	int counter;


	class myPanel extends JPanel {
		int r = (int) (new Random(10000).nextDouble() * 40 + 35);

		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			int w = getWidth();
			int h = getHeight();
			Graphics2D g2d = (Graphics2D) arg0;
			g2d.setColor(new Color(100, 44, 55));
			g2d.fillOval((int) x, (int) y, r5, r5);
			for (int i = 0; i < arr.length; i++) {
				if (state[i] == 0) {
				g2d.drawOval(X[i], Y[i], arr[i], arr[i]);
				}	
			}
			g2d.fillOval((int) x1, (int) y1, 15, 15);
			if (win == -1) {
				g2d.setColor(new Color(255, 0, 0));
				g2d.fillRect(0, 0, w, h);
				g2d.setColor(Color.BLACK);
				g2d.drawLine(w / 6, h / 12, w / 4, h / 6);
				g2d.drawLine(w / 4, h / 6, w / 3, h / 12);
				g2d.drawLine(w / 4, h / 6, w / 4, h / 3);
				g2d.drawLine(5 * w / 12, h / 12, 7 * w / 12, h / 12);
				g2d.drawLine(7 * w / 12, h / 12, 7 * w / 12, h / 3);
				g2d.drawLine(7 * w / 12, h / 3, 5 * w / 12, h / 3);
				g2d.drawLine(5 * w / 12, h / 3, 5 * w / 12, h / 12);
				g2d.drawLine(3 * w / 4, h / 12, 3  * w / 4, h / 3);
				g2d.drawLine(3 * w / 4, h / 3, 11 * w / 12, h / 3);
				g2d.drawLine(11 * w / 12, h / 3, 11 * w / 12, h / 12);
				g2d.drawLine(w / 12, 7 * h / 12, w / 12, 5 * h / 6);
				g2d.drawLine(w / 12, 5 * h / 6, w / 4, 5 * h / 6);
				g2d.drawLine(w / 3, h * 7 / 12, w / 2, h * 7 / 12);
				g2d.drawLine(w / 2, 7 * h / 12, w / 2, 5 * h / 6);
				g2d.drawLine(w / 2, 5 * h / 6, w  / 3, 5 * h / 6);
				g2d.drawLine(w / 3, 5 * h / 6, w / 3, h * 7 / 12);
				g2d.drawLine(3 * w / 4, 7 * h / 12, 7 * w / 12, 7 * h / 12);
				g2d.drawLine(7 * w / 12, 3 * h / 4, 7 * w / 12, 7 * h / 12);
				g2d.drawLine(7 * w / 12, 3 * h / 4, 3 * w / 4, 3 * h / 4);
				g2d.drawLine(3 * w / 4, 3 * h / 4, 3 * w / 4, h * 5  / 6);
				g2d.drawLine(3 * w / 4, 5 * h / 6, 7 * w / 12, 5 * h / 6);
				g2d.drawLine(5 * w / 6, 7 * h / 12, w, 7 * h / 12);
				g2d.drawLine(11 * w / 12, 7 * h / 12, 11 * w / 12, 5 * h / 6);
			}
			if (win == 1) {
				g2d.setColor(new Color(0, 255, 0));
				g2d.fillRect(0, 0, w, h);
				g2d.setColor(Color.BLACK);
				g2d.drawLine(w / 6, h / 12, w / 4, h / 6);
				g2d.drawLine(w / 4, h / 6, w / 3, h / 12);
				g2d.drawLine(w / 4, h / 6, w / 4, h / 3);
				g2d.drawLine(5 * w / 12, h / 12, 7 * w / 12, h / 12);
				g2d.drawLine(7 * w / 12, h / 12, 7 * w / 12, h / 3);
				g2d.drawLine(7 * w / 12, h / 3, 5 * w / 12, h / 3);
				g2d.drawLine(5 * w / 12, h / 3, 5 * w / 12, h / 12);
				g2d.drawLine(3 * w / 4, h / 12, 3  * w / 4, h / 3);
				g2d.drawLine(3 * w / 4, h / 3, 11 * w / 12, h / 3);
			}
		}
	}

	public void run() {
		win = 0;
		x1 = 200;
		y1 = 200;
		vx = 1;
		vy = 1;
		counter = 0;
		V = 0.5;
		JFrame window = new JFrame("dsf");
		window.setSize(1000, 1000);
		myPanel p = new myPanel();
		window.add(p);
		r = 55;
		W = window.getWidth();
		H = window.getHeight();
		R1 = (int) (Math.random() * 25 + 7);
		R2 = (int) (Math.random() * W);
		R3 = (int) (Math.random() * H);
		arr = new int[r];
		X = new int[r];
		Y = new int[r];
		state = new int[r];
		for (int i = 0; i < r; i++) {
			state[i] = 0;
			arr[i] = R1;
			X[i] = R2;
			Y[i] = R3;
			R1 = (int) (Math.random() * 13 + 5);
			R2 = (int) (Math.random() * W);
			R3 = (int) (Math.random() * H);
			window.repaint();
		}
		p.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				EX = e.getX();
				EY = e.getY();
			}

			@Override
			public void mouseDragged(MouseEvent e) {

			}

		});
		t = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x += vx;
				y += vy;
				double l = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
				x1 += ((x - x1) / l) * V;
				y1 += ((y - y1) / l) * V;
				double r = Math.sqrt(Math.pow((EX - (x + r5 / 2)), 2) + Math.pow((EY - (y + r5 / 2)), 2));
				vy += -10 * ((y + r5 / 2) - EY) / 1.0 / r / r;
				vx += -10 * ((x + r5 / 2) - EX) / 1.0 / r / r;
				window.repaint();
				for (int i = 0; i < arr.length; i++) {
					if (Math.sqrt(((x + r5 / 2) - (X[i] + arr[i] / 2)) * ((x + r5 / 2) - (X[i] + arr[i] / 2))
							+ ((y + r5 / 2) - (Y[i] + arr[i] / 2)) * ((y + r5 / 2) - (Y[i] + arr[i] / 2))) < (r5
									+ arr[i]) / 2) {
						if (r5 >= arr[i]) {
						r5 += arr[i] / 5;
						arr[i] = 0;
						if (state[i] != 1) {
						state[i] = 1;
						counter ++;
						}
						}
						else {
							win = -1;
						}
					}		
				}
				if (Math.sqrt(Math.pow((x1 + 15 / 2) - (x + r5 / 2), 2) + Math.pow((y1 + 15 / 2) - (y + r5 / 2), 2)) <= (15 + r5) / 2) {
					r5 /= 1.5;
					vx = -vx;
					vy = -vy;
				}
				if (p.getWidth() < x + r5 || x < 0) {
					vx = -vx;
				}
				if (p.getHeight() < y + r5 || y < 0) {
					vy = -vy;
				}
				window.repaint();
			}
		});
		t.start();

		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	public static void main(String[] args) {
		new test1().run();
	}
}