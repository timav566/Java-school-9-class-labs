
//Vasilevskij Timofey 9a class 
//25022018 
//Set of Mandelbrot and Set of Julia
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.*;

public class test {

	static class Complex {
		double Real;
		double Imaginary;
		double abs;
		double a;
		double b;

		Complex(double re, double im) {
			this.Real = re;
			this.Imaginary = im;
		}

		public void add(Complex z) {
			Real += z.Real;
			Imaginary += z.Imaginary;
		}

		public void add1(double a, double b) {
			Real += a;
			Imaginary += b;
		}

		public void sub(Complex z) {
			Real -= z.Real;
			Imaginary -= z.Imaginary;
		}

		public void mult(Complex z) {
			double tmp = Real * Real - Imaginary * Imaginary;
			double tmp2 = 2 * Real * Imaginary;
			Real = tmp;
			Imaginary = tmp2;
		}

		public void module(Complex z) {
			abs = Math.sqrt(Real * Real + Imaginary * Imaginary);
		}

		public void NextZ(Complex z, Complex z0) {
			this.mult(z);
			this.add(z0);
		}

		public void NextZ1(Complex z, double a, double b) {
			this.mult(z);
			this.add1(a, b);
		}
	}

	static class myPanel1 extends JPanel {
		public double x1;
		public double y1;
		public double k;
		public int n;
		public myPanel1(double x1, double y1, double k, int n){
			this.x1 = x1;
			this.y1 = y1;
			this.k = k;
			this.n = n;
		}
		public static void koordinateX1(double x1, myPanel1 julia) {
			julia.x1 = x1;
		}
		public static void koordinateY1(double y1, myPanel1 m2) {
			m2.y1 = y1;
		}
		public static void Zoom1(double k, myPanel1 julia) {
			julia.k = k;
		}
		public static void Cycle1(int n, myPanel1 julia) {
			julia.n = n;
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			Graphics2D g2d = (Graphics2D) arg0;
			int h = getHeight();
			int w = getWidth();
			for (int i = 0; i <= h; i++) {
				for (int j = 0; j <= w; j++) {
					int i1 = i - h / 2;
					int j1 = j - w / 2;
					double x = j1 * 2 * k / w;
					double y = i1 * 2 * k / h;
					x += x1;
					y -= y1;
					Complex z = new Complex(x, y);
					Complex z0 = new Complex(x, y);
					int g = 0;
					for (; g < n; g++) {
						z.module(z);
						if (z.abs >= 2) {
							break;
						}
						z.NextZ(z, z0);
					}
					g2d.setColor(new Color(g * 6 % 256, g * 979 % 256, g * 452 % 256));
					g2d.drawLine(j, i, j, i);
				}
			}
		}
	}

	static class myPanel2 extends JPanel {
		public double a;
		public double b;	
		public double x1;
		public double y1;
		public double k;
		public int n;
		public myPanel2(double a, double b, double x1, double y1, double k, int n){
			this.a = a;
			this.b = b;
			this.x1 = x1;
			this.y1 = y1;
			this.k = k;
			this.n = n;
		}
		public static void firstNumber(double a, myPanel2 julia){
			julia.a = a;
		}
		public static void secondNumber(double b, myPanel2 julia){
			julia.b = b;
		}
		public static void koordinateX(double x1, myPanel2 julia) {
			julia.x1 = x1;
		}
		public static void koordinateY(double y1, myPanel2 julia) {
			julia.y1 = y1;
		}
		public static void Zoom(double k, myPanel2 julia) {
			julia.k = k;
		}
		public static void Cycle(int n, myPanel2 julia) {
			julia.n = n;
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			Graphics2D g2d = (Graphics2D) arg0;
			int h = getHeight();
			int w = getWidth();
			for (int i = 0; i <= h; i++) {
				for (int j = 0; j <= w; j++) {
					int i1 = i - h / 2;
					int j1 = j - w / 2;
					double x = j1 * 2 * k / w;
					double y = i1 * 2 * k / h;
					x += x1;
					y -= y1;
					Complex z = new Complex(x, y);
					int g = 0;
					for (; g < n; g++) {
						z.module(z);
						if (z.abs >= 2) {
							break;
						}
						z.NextZ1(z, a, b);
					}
					g2d.setColor(new Color(g * 49 % 256, g * 4 % 256, g * 45 % 256));
					g2d.drawLine(j, i, j, i);
				}
			}
		}
	}
	public static void main(String[] args) {
		JFrame window = new JFrame("dsf");
		window.setSize(500, 500);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panelWest = new JPanel();
		window.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
		JCheckBox CH1 = new JCheckBox("NorthPanel");
		JCheckBox CH2 = new JCheckBox("SouthPanel");
		panelWest.add(CH1);
		panelWest.add(CH2);
		panelWest.setVisible(true);
		JPanel up = new JPanel();
		JPanel down = new JPanel();
		JPanel center = new JPanel();
		myPanel1 m1 = new myPanel1(0, 0, 2, 1000);
		JTextField text1 = new JTextField();
		JTextField text2 = new JTextField();
		text1.setText("0.29");
		text2.setText("0.0113");
		myPanel2 m2 = new myPanel2(0.28, 0.0113, 0.1 , 0.2, 2, 1000);
		window.add(center, BorderLayout.CENTER);
		window.add(up, BorderLayout.NORTH);
		window.add(down, BorderLayout.SOUTH);
		JButton button1 = new JButton("Redraw");
		up.setLayout(new GridLayout(2, 2));
		down.setLayout(new FlowLayout());
		up.setVisible(false);
		down.setVisible(false);
		JTextField text3 = new JTextField(5);
		text3.setText("0");
		JTextField text4 = new JTextField(5);
		text4.setText("0");
		JTextField text5 = new JTextField(5);
		text5.setText("2");
		JTextField text6 = new JTextField(5);
		text6.setText("1000");
		
		CH1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				up.setVisible(!up.isVisible()); 
			} 
		}); 
		CH2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				down.setVisible(!down.isVisible());
			} 
		});
		button1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myPanel2.firstNumber(Double.parseDouble(text1.getText()), m2);
				myPanel2.secondNumber(Double.parseDouble(text2.getText()), m2);
				myPanel2.koordinateX(Double.parseDouble(text3.getText()), m2);
				myPanel2.koordinateY(Double.parseDouble(text4.getText()), m2);
				myPanel2.Zoom(Double.parseDouble(text5.getText()), m2);
				myPanel2.Cycle(Integer.parseInt(text6.getText()), m2);
				window.repaint();
			} 
		});
		button1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myPanel1.koordinateX1(Double.parseDouble(text3.getText()), m1);
				myPanel1.koordinateY1(Double.parseDouble(text4.getText()), m1);
				myPanel1.Zoom1(Double.parseDouble(text5.getText()), m1);
				myPanel1.Cycle1(Integer.parseInt(text6.getText()), m1);
				window.repaint();
			} 
		});
		ButtonGroup BG = new ButtonGroup();
		JRadioButton B1 = new JRadioButton("Mandelbrot");
		JRadioButton B2 = new JRadioButton("Julia");
		BG.add(B1);
		BG.add(B2);
		up.setLayout(new GridLayout(2, 3));
		up.add(B1);
		up.add(text1);
		up.add(button1);
		up.add(B2);
		up.add(text2);
		center.setLayout(new GridLayout(0, 1));
		
		B1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				center.removeAll();
				center.revalidate();
				center.setLayout(new GridLayout(0, 1));
				center.add(m1);
				text1.setVisible(false);
				text2.setVisible(false);
				window.repaint();
			} 
		});
		B2.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				center.removeAll();
				center.revalidate();
				center.setLayout(new GridLayout(0, 1));
				center.add(m2);
				text1.setVisible(true);
				text2.setVisible(true);
				window.repaint();
			} 
		});
		JLabel label1 = new JLabel("x");
		JLabel label2 = new JLabel("y");
		JLabel label3 = new JLabel("zoom");
		JLabel label4 = new JLabel("cycle");
		down.add(label1);
		down.add(text3);
		down.add(label2);
		down.add(text4);
		down.add(label3);
		down.add(text5);
		down.add(label4);
		down.add(text6);
		window.setVisible(true);
	}
}