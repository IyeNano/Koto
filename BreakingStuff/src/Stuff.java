
public class Stuff {

	public static void main(String[] args) {
		
		for (int i = 1; i > 0;) {
			if (i != 10) {
				System.out.println("Stuff is not broken");
				i++;
			} else {
				System.out.println("Stuff is broken");
				break;
			}
		}
	}
}
