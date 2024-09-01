import static java.lang.System.out;
import java.util.Scanner;

public class PercentageBar {
	private static Scanner readInput = new Scanner(System.in);
	private static final double TOTAL_PER = 100;
	private static double total;

	static {
		out.print("Enter the total: ");
		total = readInput.nextDouble();
	}

	public static void main(String[] args) {
		
		double current = 0;
		double currentPercentage = 0;
		boolean on = true;
		while(on) {
			current += (total * getRandomPer());
			currentPercentage = (current / total)  * 100;
			out.println("current: " +current +" percentage: " +currentPercentage);
			if(currentPercentage > 95) {
				printPercentage(total, (TOTAL_PER - currentPercentage));
				on = false;
			} else {
				printPercentage(total, currentPercentage);
			}

			delayer(10);
		}
	}

	private static void delayer(int tick) {
		int times = tick * 5000000;
		for(int x = 0; x < times; x++) { out.print(""); }
	}

	private static double getRandomPer() {
		double randomPer = Math.random();

		while(randomPer < .1 || randomPer > .5) {
			randomPer = Math.random();
		}

		return randomPer;
	}

	private static void printPercentage(double total, double current) {
		out.println();
		
		for(int lair = 1; lair < 4; lair++) {

			for(int x = 0; x < (TOTAL_PER + 2); x++) {
				if(lair==1) {
					if(x == 0 || x == (TOTAL_PER + 1)) {
						out.print(" ");
					} else {
						out.print("-");
					}
				} else if(lair==2) {
					if(x == 0 || x == (TOTAL_PER + 1)) {
						out.print("|");
					} else {
						if(current > 0) {
							out.print("|");
							--current;
						} else {
							out.print(".");
						}
					}
				} else {
					if(x == 0 || x == (TOTAL_PER + 1)) {
						out.print(" ");
					} else {
						out.print("-");
					}
				}
			}
			out.println();
		}
	}

}

// java PercentageBar.java