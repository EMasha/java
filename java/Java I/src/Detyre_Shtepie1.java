import java.util.Scanner;
public class Detyre_Shtepie1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Vendos vleren a:");
		double a = input.nextDouble();
		if (a != 0) {
			System.out.print("Vendos vleren b:");
			double b = input.nextDouble();
			System.out.print("Vendos vleren c:");
			double c = input.nextDouble();
			if ( b * b - 4 * a * c <=0) {
				System.out.println("Ju lutem beni refresh dhe vendosni nje vlere tjeter per b ose c");
			}else {
				System.out.println("Rezultati per formulen b^2 - 4ac eshte : " + (b*b - 4 * a* c));
				double x1 = -b - c/a;
				double x2 = b+ c/a;
				System.out.println("Zgjidhja e pare per X eshte: " + x1);
				System.out.println("Zgjidhja e dyte per X eshte: " + x2);
			}
		} else {
			System.out.println("Ju lutem beni refresh dhe vendosni nje vlere tjeter");
		}

	}

}
