import java.util.Scanner;
public class Detyre_Shtepie2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double sasia = -1;
		double perqindja = 0.00;
		int muaj = 0;
		System.out.print("Vendosni vleren fillestare: ");
		sasia = input.nextInt();
		System.out.print("Vendosni perqindjen vjetore: ");
		perqindja = input.nextDouble();
		System.out.print("Vendosni numrin e muajve: ");
		muaj = input.nextInt();
		for (int i=1; i<=muaj; i++) {
			sasia = sasia + (sasia * perqindja)/1200;
			System.out.print(i+" ");
			System.out.println(sasia);
		}
		
	}

}
