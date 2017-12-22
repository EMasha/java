
public class Detyre_Shtepie3 {

	public static void main(String[] args) {
		int zari1 =(int)(Math.random()*5+1);
		int zari2 =(int)(Math.random()*5+1);
		int sum = zari1+zari2;
		if(sum <= 3 || sum == 12 ) {
			System.out.println("Ti hodhe "+zari1 +" + " + zari2 +" = " + sum + ". Ti humbe!");
		}else if (sum == 7 || sum == 11 ){
			System.out.println("Ti hodhe "+zari1 +" + " + zari2 +" = " + sum + ". Ti fiton!");
		}else {
			System.out.println("Ti hodhe "+ zari1 +" + " + zari2 +" = " + sum + ". Piket jane "+ sum +". Hidhni serisht!");
			int zari3 =(int)(Math.random()*5+1);
			int zari4 =(int)(Math.random()*5+1);	
			int sum2 = zari3+zari4;
			int total = sum + sum2;
			if(total == 12) {
				System.out.println("Ti hodhe "+zari3 +" + " + zari4 +" = " + sum2 + ". Ti humbe!");
			}else {
				System.out.println("Ti hodhe "+zari3 +" + " + zari4 +" = " + sum2 + ". Ti fiton!");
			}
		}
	}
}
