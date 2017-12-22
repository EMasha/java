
public class demo1_4 {

	public static void main(String[] args) {
		final Object[][] table = new String[5][];
		table[0] = new String[] { "a", "a^2", "a^3" };
		table[1] = new String[] { "1", "1", "1" };
		table[2] = new String[] { "2", "4", "8" };
		table[3] = new String[] { "3", "9", "16" };
		table[4] = new String[] { "4", "16", "64" };

		for (final Object[] row : table) {
		    System.out.format("%15s%15s%15s\n", row);
		}
	}

}
