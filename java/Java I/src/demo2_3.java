import java.util.Scanner;
public class demo2_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Vendos 3 numra: ");
		double nr1 = input.nextDouble();
		double nr2 = input.nextDouble();
		double nr3 = input.nextDouble();
		double mesatarja = (nr1 + nr2 + nr3) / 3;
		System.out.print("Mesatarja eshte : " + mesatarja);
	}

}
