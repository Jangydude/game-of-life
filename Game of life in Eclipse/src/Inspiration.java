
public class Inspiration {
	public static void main(String[] args) {

		int len = 20;
		int[][] mat = new int[len][len];

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setCanvasSize(750, 750);
		StdDraw.setScale(0, 750);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenRadius(0.015);

		StdDraw.clear(StdDraw.WHITE);

		StdDraw.line(600,700,750,700);
		StdDraw.line(600,  700,  600,  600);
		StdDraw.line(600, 600, 750, 600);
		StdDraw.line(750,  700,  750,  600);

		while (true) {
			if (StdDraw.mouseClicked()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				System.out.println("" + x + y);
				StdDraw.mouseClicked = false;
				
				if (1!=0) {
					break;
				}
			}
			StdDraw.mouseClicked = false;
			
		}
		
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
					StdDraw.filledRectangle((600 / (2 * len)) + (600 * c / len),
							600 - (600 / (2 * len)) - (600 * (r) / len), 600 / (2 * len), 600 / (2 * len));

				}
				if (c != len - 1) {
					StdDraw.setPenColor(StdDraw.BLUE);
					StdDraw.setPenRadius(0.001);
					StdDraw.line((600 / (2 * len)) + (600 * c / len) + (600 / (2 * len)),
							600 - (600 / (2 * len)) - (600 * (r) / len) + (600 / (2 * len)),
							(600 / (2 * len)) + (600 * c / len) + (600 / (2 * len)), 0);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.setPenRadius(0.015);
				}
			}
			if (r != len - 1) {
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.setPenRadius(0.001);
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
}
