import java.lang.Object;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Canvas;
import javax.swing.JFrame;

/**
 * Write a description of class GoL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GoL {
	// instance variables - replace the example below with your own
	private int len;
	private int[][] grid;
	private int[][] copy;

	public GoL() {
		len = 0;
		grid = null;
		copy = null;
	}

	public GoL(int gridSize) {
		len = gridSize;
		grid = new int[gridSize][gridSize];
		copy = new int[gridSize][gridSize];

	}

	public void random() {
		for (int x = 0; x < len; x++) {
			for (int y = 0; y < len; y++) {
				int easy = (int) (2.0 * Math.random());
				if (easy < 1) {
					grid[x][y] = 1;
				} else {
					grid[x][y] = 0;
				}
			}
		}

	}

	public void copyGrid() {

		for (int x = 0; x < len; x++) {
			for (int y = 0; y < len; y++) {
				copy[x][y] = grid[x][y];
			}
		}
	}

	public void setUp() {

		giveMeStd(len);

		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.setPenRadius(0.002);
				StdDraw.line((600 / (2 * len)) + (600 * c / len) + (600 / (2 * len)),
						600 - (600 / (2 * len)) - (600 * (r) / len) + (600 / (2 * len)),
						(600 / (2 * len)) + (600 * c / len) + (600 / (2 * len)), 0);
			}
			StdDraw.line((600 / (2 * len)) + (600 * 0 / len) - (600 / (2 * len)),
					600 - (600 / (2 * len)) - (600 * (r) / len) - (600 / (2 * len)), 600,
					600 - (600 / (2 * len)) - (600 * (r) / len) - (600 / (2 * len)));
		}

		StdDraw.line(600, 700, 750, 700);
		StdDraw.line(600, 700, 600, 600);
		StdDraw.line(600, 600, 750, 600);
		StdDraw.line(750, 700, 750, 600);
		StdDraw.text(675, 650, "START");

		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setFont(new Font("Courier", Font.BOLD, 30));
		StdDraw.text(675, 450, "GLORY");
		StdDraw.text(675, 400, "GLORY");
		StdDraw.text(675, 350, "MAN");
		StdDraw.text(675, 300, "UNITED");
		StdDraw.setPenColor(StdDraw.BLUE);
		
		StdDraw.setFont(new Font("Courier",Font.PLAIN, 20));
		StdDraw.text(350, 720, "Because this was made using StdDraw (very hard to scale)");
		StdDraw.text(300, 690, "if the user wants to select of deselect a box,");
		StdDraw.setFont(new Font("Courier",Font.PLAIN, 15));
		StdDraw.text(300, 660, "he/she needs to click the bottom right corner of the box.");


		while (true) {
			if (StdDraw.mouseClicked() == true) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();

				if (x > 0 && x < 600 && y > 0 && y < 600) {
					updatePoint(x - 1, y - 1);
				}
				if (x > 600 && x < 750 && y > 600 && y < 700) {
					break;
				}
				StdDraw.mouseClicked = false;
			}

		}

	}
	
	public void randomColor() {
		int r = (int)(256*Math.random());
		int g = (int)(256*Math.random());
		int b = (int)(256*Math.random());
		StdDraw.setPenColor(r, g, b);
	}

	public void updatePoint(double xx, double yy) {
		int r = (int) ((2 * len * yy - 1200 * len + 600) / -1200);
		int c = (int) ((2 * len * xx - 600) / 1200);
		if (r >= 0 && r <= len && c >= 0 && c <= len) {
			if (copy[r][c] == 1) {
				grid[r][c] = 0;
				copyGrid();
				StdDraw.setPenColor(StdDraw.WHITE);
			} else {
				grid[r][c] = 1;
				copyGrid();
				randomColor();
			}
			StdDraw.filledRectangle((600 / (2 * len)) + (600 * c / len), 600 - (600 / (2 * len)) - (600 * (r) / len),
					600 / (2 * len) - (len / 30), 600 / (2 * len) - (len / 30));

			for (r = 0; r < len; r++) {
				for (c = 0; c < len; c++) {
					StdDraw.setPenColor(StdDraw.BLUE);
					StdDraw.setPenRadius(0.002);
					StdDraw.line((600 / (2 * len)) + (600 * c / len) + (600 / (2 * len)),
							600 - (600 / (2 * len)) - (600 * (r) / len) + (600 / (2 * len)),
							(600 / (2 * len)) + (600 * c / len) + (600 / (2 * len)), 0);
				}
				StdDraw.line((600 / (2 * len)) + (600 * 0 / len) - (600 / (2 * len)),
						600 - (600 / (2 * len)) - (600 * (r) / len) - (600 / (2 * len)), 600,
						600 - (600 / (2 * len)) - (600 * (r) / len) - (600 / (2 * len)));
			}

			StdDraw.show();
		}

	}

	public int nbor(int i, int j) {
		if (copy[i][j] == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	public void nextGen() {
		copyGrid();
		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				int counter = ncount(r, c);
				if (nbor(r, c) == 1) {
					if (counter == 0 || counter == 1 || counter >= 4) {
						grid[r][c] = 0;
					}
				} else if (nbor(r, c) == 0) {
					if (counter == 3) {
						grid[r][c] = 1;
					}
				}
			}
		}
		copyGrid();
	}

	public int ncount(int y, int x) {
	
		if (x == 0 && y == 0) {
			return nbor(y + 1, x) + nbor(y + 1, x + 1) + nbor(y, x + 1);
		} else if (y == len - 1 && x == 0) {
			return nbor(y - 1, x) + nbor(y - 1, x + 1) + nbor(y, x + 1);
		} else if (y == 0 && x == len - 1) {
			return nbor(y, x - 1) + nbor(y + 1, x - 1) + nbor(y + 1, x);
		} else if (y == len - 1 && x == len - 1) {
			return nbor(y, x - 1) + nbor(y - 1, x - 1) + nbor(y - 1, x);
		} else if (x == 0) {
			return nbor(y - 1, x) + nbor(y - 1, x + 1) + nbor(y, x + 1) + nbor(y + 1, x + 1) + nbor(y + 1, x);
		} else if (y == len - 1) {
			return nbor(y, x - 1) + nbor(y - 1, x - 1) + nbor(y - 1, x) + nbor(y - 1, x + 1) + nbor(y, x + 1);
		} else if (y == 0) {
			return nbor(y, x - 1) + nbor(y + 1, x - 1) + nbor(y + 1, x) + nbor(y + 1, x + 1) + nbor(y, x + 1);
		} else if (x == len - 1) {
			return nbor(y - 1, x) + nbor(y - 1, x - 1) + nbor(y, x - 1) + nbor(y + 1, x - 1) + nbor(y + 1, x);
		}
	
		else {
			return nbor(y - 1, x - 1) + nbor(y - 1, x) + nbor(y - 1, x + 1) + nbor(y, x - 1) + nbor(y, x + 1)
					+ nbor(y + 1, x - 1) + nbor(y + 1, x) + nbor(y + 1, x + 1);
		}
	}

	public void initializeStdDraw(int length) {

		// StdDraw.enableDoubleBuffering();
		// uncomment if you want a smooth animation.
		// you would also need to have these two calls after you draw the lines

		// StdDraw.pause(ms); /// Where ms are milliseconds (it can be zero)
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setCanvasSize(600, 600);
		StdDraw.setScale(0, 600);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenRadius(0.015);

	}

	public static void giveMeStd(int length) {

		// StdDraw.enableDoubleBuffering();
		// uncomment if you want a smooth animation.
		// you would also need to have these two calls after you draw the lines

		// StdDraw.pause(ms); /// Where ms are milliseconds (it can be zero)
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setCanvasSize(900, 600);
		StdDraw.setScale(0, 900);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenRadius(0.015);

		StdDraw.show();

	}

	public void plot(int[][] mat) {
		StdDraw.clear(StdDraw.WHITE);
		// System.out.println("plot work");
		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				if (mat[r][c] == 1) {
					// System.out.println("works!");
					/*
					 * StdDraw.filledRectangle(100,100,10,10); StdDraw.filledRectangle(200,200,3,3);
					 * StdDraw.filledRectangle(300,300,10,10);
					 * StdDraw.filledRectangle(600,600,10,10);
					 */
					// System.out.println((600/(2*len))+(600*c/len));
					// System.out.println(600-(600/(2*len))-(600*(r)/len));
					// System.out.println(600/(2*len));
					randomColor();
					StdDraw.filledRectangle((600 / (2 * len)) + (600 * c / len),
							600 - (600 / (2 * len)) - (600 * (r) / len), 600 / (2 * len), 600 / (2 * len));

				}
				if (c != -1) {
					StdDraw.setPenColor(StdDraw.BLUE);
					StdDraw.setPenRadius(0.002);
					StdDraw.line((600 / (2 * len)) + (600 * c / len) + (600 / (2 * len)),
							600 - (600 / (2 * len)) - (600 * (r) / len) + (600 / (2 * len)),
							(600 / (2 * len)) + (600 * c / len) + (600 / (2 * len)), 0);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.setPenRadius(0.015);
				}
			}
			if (r != -1) {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.setPenRadius(0.002);
				StdDraw.line((600 / (2 * len)) + (600 * 0 / len) - (600 / (2 * len)),
						600 - (600 / (2 * len)) - (600 * (r) / len) - (600 / (2 * len)), 600,
						600 - (600 / (2 * len)) - (600 * (r) / len) - (600 / (2 * len)));
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.setPenRadius(0.015);
			}
		}
		// StdDraw.pause(50);
		StdDraw.show();

	}

	public void graphics() {

		copyGrid();
		plot(copy);
	}

	public String toString() {
		String mat = "";

		copyGrid();
		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				mat += copy[r][c] + " ";
			}
			mat += "\n";
		}
		return mat;
	}
}
