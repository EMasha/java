
public class demo1_11 {
	public static void main(String[] args) {
		int sec = 60*60*24;
		int birth = sec/7;
		int death = sec/13;
		int immigrants = sec/45;
		int pop = 312032486;
		int year = 365 * (birth - death + immigrants);
		System.out.println("Population today is: " + pop);
		System.out.println("Population 2018: " + (pop + year));
		System.out.println("Population 2019: " + (pop + year * 2));
		System.out.println("Population 2020: " + (pop + year * 3));
		System.out.println("Population 2021: " + (pop + year * 4));
		System.out.println("Population 2022: " + (pop + year * 5));
		
	}

}
