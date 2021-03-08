//Vasilevskij Timofey
//26042018
//SuperBestGame

public class Hittable {
	int x;
	int y;
	int h;
	int w;
	static final int east = 3;
	static final int west = 1;
	static final int north = 2;
	static final int south = 4;

	int hitTest(int BallX, int BallY, int BallR) {
		// 1 - left
		// 2 - up
		// 3 - right
		// 4 - down
		int a = 0;
		int X = BallX - BallR / 2;
		int Y = BallY - BallR / 2;
		if (Y - y <= h + BallR / 2 && Y - y >= 0 && x - X <= BallR && x - X >= -(w)) {
			a = north;
		}
		if (y - Y <= BallR && y - Y >= 0 && x - X <= BallR && x - X >= -(w)) {
			a = south;
		}
		if (Y >= y - BallR && Y <= y + h && X > x - BallR && X <= x) {
			a = east;
		}
		if (Y >= y - BallR && Y <= y + h && X <= x + w && X >= x + w - BallR) {
			a = west;
		}
		return a;
	}
}
