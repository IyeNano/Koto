public class StatBlockRollTest {
	public static void main(String[] args) {
		// Test to see if the stat block rolls randomly between 10 and 15
		
		int str1 = (int)(Math.random()*6) + 10;
		int dex1 = (int)(Math.random()*6) + 10;
		int con1 = (int)(Math.random()*6) + 10;
		int int1 = (int)(Math.random()*6) + 10;
		int wis1 = (int)(Math.random()*6) + 10;
		int cha1 = (int)(Math.random()*6) + 10;
		
		System.out.println("Strength: " + str1);
		System.out.println("Dexterity: " + dex1);
		System.out.println("Constitution: " + con1);
		System.out.println("Intelligence: " + int1);
		System.out.println("Wisdom: " + wis1);
		System.out.println("Charisma: " + cha1);
	}

}
