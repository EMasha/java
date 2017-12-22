import java.util.Scanner;
public class demo5_2_1 {

	public static void main(String[] args) {
		int nr = (int)(Math.random()*101);
		Scanner input = new Scanner (System.in);
		System.out.println("Gjej numrin nga 0-100: ");
		int gjej = -1;
		while (gjej != nr) {
			System.out.print("Vendosni numrin tuaj: ");
			gjej = input.nextInt();
			
			if (gjej == nr) {
				System.out.println("Ju e gjete numrin e sakte i cili eshte " + nr);
			}
			else if(gjej>nr) {
				System.out.println("Numri eshte shume i madh.");		
			}
			else {
				System.out.println("Numri eshte shume i vogel.");
			}
		}

	}

}
