import java.util.Scanner;
public class Demo7_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Vendos numrin e lendeve: ");
		int nr = input.nextInt();
		double[] numrat = new double[nr];
		double sum = 0;
		
		System.out.print("Vendos notat: ");
		for(int i=0; i<nr; i++) {
			numrat[i] = input.nextDouble(); 
			sum = sum + numrat[i];
		}
		double mesatarja = sum/nr;
		
		int numrimi = 0;
		for (int i=0; i<nr; i++) {
			if (numrat[i]>mesatarja) {
				numrimi++;
			}
		}
		System.out.println("Mesatarja eshte: " + mesatarja);
		System.out.println("Numri i lendeve me mesatare mbi "+ mesatarja + " eshte " + numrimi);
	}

}
