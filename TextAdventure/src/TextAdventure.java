import java.util.Scanner;

public class TextAdventure {
	public static void main(String[] args) {
		/* This is a text adventure meant to run off of a rolling system similar to 
		 * Dungeons & Dragons. I will be utilizing rules from edition 3.5 just because
		 * that is the version of D&D I am most familiar. This was inspired by Karamel's
		 * Rock, Paper, Scissors Quest he made for Homework 3(? memory fuzzy). It's
		 * going to run basic "Zork" progression as I hope not to railroad it nearly
		 * as much.
		 */
		
		//startIntroLoreAndCC custom method to establish Player Character
		startIntroLoreAndCC();
	}
	
	public static void startIntroLoreAndCC() {
		
		System.out.println("In the land of E'sural, where the sun-scorched sands glow \nand summer heat remains eternal, you find yourself in a \ndesolate village devoid of life.");
		System.out.println("Do you awaken? Y/N");
		
		Scanner introInput = new Scanner(System.in);
		String continueChoice1 = introInput.next();
		
		
		//User input to start or kill adventure at start
		if ((continueChoice1.equalsIgnoreCase("N")) || (continueChoice1.equalsIgnoreCase("No"))) {
			System.out.println("You succomb to the elements and perish.");	
		} else if ((continueChoice1.equalsIgnoreCase("Y")) || (continueChoice1.equalsIgnoreCase("Yes"))) {
			System.out.println("You awaken inside a sand-covered hut wrapped in bandages with only one eye uncovered. " +
								"\nA mirror nearby reveals your wrappings as aged and decrepit and were it not for the " +
								"\nheat of the world itself, the bandages would be cold to the touch. You start to remove" +
								"\nthe bandages surrounding yourself in search of your body inside. When you see yourself" +
								"\nin the mirror, all you can muster is 'Who am i?'");
			System.out.println("What is your name?");
			
			//Prompt user for name
			introInput.nextLine(); //For some reason, this needs to exist to make the next line work
			String playerName = introInput.nextLine();
			
			//Prompt user for character race
			System.out.println("Under what lineage where you born?");
			System.out.println("Human (1), Elf (2), Half-Elf (3), Dwarf (4), Tiefling (5), or Halfling (6)?");
			
			int playerRace = introInput.nextInt();
			
			if (playerRace == 1) {
				System.out.println("A Human lineage: born with bravery.");
				
			} else if (playerRace == 2) {
				System.out.println("An Elven lineage: born with patience.");
				
			} else if (playerRace == 3) {
				System.out.println("A Half-Elf lineage: born with integrity.");
				
			} else if (playerRace == 4) {
				System.out.println("A Dwarven lineage: born with hardiness.");
				
			} else if (playerRace == 5) {
				System.out.println("A Tiefling lineage: born with ambition.");
				
			} else if (playerRace == 6) {
				System.out.println("A Halfling lineage: born with determination.");
				
			}
			
			//Prompt user for Age and Gender
			System.out.println("Are you male or female?");
			
			String playerGender = introInput.next();
			
			if ((playerGender.equalsIgnoreCase("male")) || 
					(playerGender.equalsIgnoreCase("man")) || 
					(playerGender.equalsIgnoreCase("guy")) || 
					(playerGender.equalsIgnoreCase("dude")) || 
					(playerGender.equalsIgnoreCase("bro"))) {
				System.out.println("You are a patriarch of your kin. A leader fallen from a large height.");
			} else if ((playerGender.equalsIgnoreCase("female")) || 
						(playerGender.equalsIgnoreCase("woman")) || 
						(playerGender.equalsIgnoreCase("lady")) || 
						(playerGender.equalsIgnoreCase("dudette")) || 
						(playerGender.equalsIgnoreCase("madam"))) {
				System.out.println("You are a matriarch of your kin. A kindly teacher whose wisdom is long lost.");
			}
			
			System.out.println("Do you remember your age? (Enter Age):");
			
			String playerAge = introInput.next();
			
			//Put Age responses here. Will do later.
			
			
			
			//Prompt user for class archetype
			System.out.println("Where do you gain your skill?");
			System.out.println("My Strength (1), My Alacrity (2), My Wisdom (3).");
			
			int playerArchetype = introInput.nextInt();
			
			if (playerArchetype == 1) {
				playerClassWarrior();
		} else if (playerArchetype == 2) {
				playerClassRogue();
		} else if (playerArchetype == 3) {
				playerClassMage(); 
				}
		}
		
	}

		private static void playerClassMage() {
			//custom method for establishing a mage-based class
		
		}

		private static void playerClassRogue() {
			//custom method for establishing a rogue-based class
		
		}

		private static void playerClassWarrior() {
			//custom method for establishing a warrior-based class
		
		}

}
