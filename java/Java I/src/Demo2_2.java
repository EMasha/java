import java.util.Scanner;
public class Demo2_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Vendos rrezen: ");
		double rad = input.nextDouble();
		
		double area = rad * rad * 3.14159;
		System.out.println("Siperfaqa eshte : " + area);

	}

}
