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
		
		//establish general stat block for player
		int str1 = (int)(Math.random()*6) + 10;
		int dex1 = (int)(Math.random()*6) + 10;
		int con1 = (int)(Math.random()*6) + 10;
		int int1 = (int)(Math.random()*6) + 10;
		int wis1 = (int)(Math.random()*6) + 10;
		int cha1 = (int)(Math.random()*6) + 10;
		
		
		
		//startIntroLoreAndCC custom method to establish Player Character
		startIntroLoreAndCC(str1, dex1, con1, int1, wis1, cha1);
	}
	
	public static void startIntroLoreAndCC(int str1, int dex1, int con1, int int1, int wis1, int cha1) {
		
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
			
			//Note to self: Don't let Anthony see the racial stat changes. He'd kill me.
			if (playerRace == 1) {
				System.out.println("You are of a Human lineage: born with bravery.");
				cha1 = cha1 + 1;
				wis1 = wis1 - 1;
			} else if (playerRace == 2) {
				System.out.println("You are of an Elven lineage: born with patience.");
				dex1 = dex1 + 2;
				con1 = con1 - 2;
			} else if (playerRace == 3) {
				System.out.println("You are of a Half-Elf lineage: born with integrity.");
				dex1 = dex1 + 1;
				cha1 = cha1 - 1;
			} else if (playerRace == 4) {
				System.out.println("You are of a Dwarven lineage: born with hardiness.");
				con1 = con1 + 2;
				dex1 = dex1 - 2;
			} else if (playerRace == 5) {
				System.out.println("You are of a Tiefling lineage: born with ambition.");
				dex1 = dex1 + 2;
				int1 = int1 + 2;
				cha1 = cha1 - 2;
			} else if (playerRace == 6) {
				System.out.println("You are of a Halfling lineage: born with determination.");
				dex1 = dex1 + 2;
				str1 = str1 - 2;
			}
			
			
			//Prompt user for Age and Gender
			System.out.println("Are you male or female?");
			
			String playerGender = introInput.next();
			
			if (playerGender.equalsIgnoreCase("male")) {
				System.out.println("You are a patriarch of your kin. A leader fallen from a large height.");
				wis1 = wis1 - 1;
				str1 = str1 + 1;
			} else if (playerGender.equalsIgnoreCase("female")) {
				System.out.println("You are a matriarch of your kin. A kindly teacher whose wisdom is long lost.");
				con1 = con1 + 1;
				str1 = str1 - 1;
			}
			
			
			System.out.println("Do you remember your age? (Enter Age):");
			
			String playerAge = introInput.next();
			
			
			//Prompt user for class archetype
			System.out.println("Where do you gain your skill?");
			System.out.println("My Strength (1), My Alacrity (2), My Wisdom (3).");
			
			int playerArchetype = introInput.nextInt();
			
			if (playerArchetype == 1) {
				playerClassWarrior(playerName, str1, dex1, con1, int1, wis1, cha1);
		} else if (playerArchetype == 2) {
				playerClassRogue(playerName, str1, dex1, con1, int1, wis1, cha1);
		} else if (playerArchetype == 3) {
				playerClassMage(playerName, str1, dex1, con1, int1, wis1, cha1); 
				}
		}
		
	}

		private static void playerClassMage(String playerName, 
				int str1, int dex1, int con1, int int1, int wis1, int cha1) {
			//custom method for establishing a mage-based class
			Scanner classInputMage = new Scanner(System.in);
			System.out.println("You are a mage. Adept to the arcane arts and a manipulator of reality." +
								"\nUnder what study are you proficient?");
			System.out.println("Elementalist (1), Illusionist (2), Scion (3)");
			
			int playerArchClass = classInputMage.nextInt();
			
			if (playerArchClass == 1) {
				System.out.println("You are " + playerName + ". An elementalist; capable of conjuring earth," +
						" dancing with fire, and mastering the elements.");
				//Finalizing the stats for the character
				int strFinal = str1;
				int dexFinal = dex1;
				int conFinal = con1;
				int intFinal = int1 + 2;
				int wisFinal = wis1;
				int chaFinal = cha1;
				
				int statModifier;
				
				if (intFinal % 2 == 0){
					statModifier = ((intFinal - 10) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				} else 
					statModifier = ((intFinal - 11) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				
			} else if (playerArchClass == 2) {
				System.out.println("You are " + playerName + ". An illusionist; capable of manipulating the senses" +
						"and warping the mind");
				//Finalizing the stats for the character
				int strFinal = str1;
				int dexFinal = dex1;
				int conFinal = con1;
				int intFinal = int1;
				int wisFinal = wis1 + 1;
				int chaFinal = cha1 + 1;
				
				int statModifier;
				
				if (intFinal % 2 == 0){
					statModifier = ((intFinal - 10) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				} else 
					statModifier = ((intFinal - 11) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				
			} else if (playerArchClass == 3) {
				System.out.println("You are " + playerName + ". A scion of the dark; a master of a lost arts.");
				//Finalizing the stats for the character
				int strFinal = str1;
				int dexFinal = dex1;
				int conFinal = con1;
				int intFinal = int1;
				int wisFinal = wis1 + 2;
				int chaFinal = cha1;
				
				int statModifier;
				
				if (intFinal % 2 == 0){
					statModifier = ((intFinal - 10) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				} else 
					statModifier = ((intFinal - 11) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				
			}
		}

		private static void playerClassRogue(String playerName, 
				int str1, int dex1, int con1, int int1, int wis1, int cha1) {
			//custom method for establishing a rogue-based class
			Scanner classInputRogue = new Scanner(System.in);
			System.out.println("You are a rogue. A deceiver and a scoundral, but cunning." +
								"\nWhat is your profession?");
			System.out.println("Thief (1), Mesmer (2), Sellsword (3)");
			
			int playerArchClass = classInputRogue.nextInt();
			
			if (playerArchClass == 1) {
				System.out.println("You are " + playerName + ". A worshipper of the coin and a controller of appraisal.");
				//Finalizing the stats for the character
				int strFinal = str1;
				int dexFinal = dex1 + 1;
				int conFinal = con1;
				int intFinal = int1 + 1;
				int wisFinal = wis1;
				int chaFinal = cha1;
				
				int statModifier;
				
				if (dexFinal % 2 == 0){
					statModifier = ((dexFinal - 10) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				} else 
					statModifier = ((dexFinal - 11) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				
			} else if (playerArchClass == 2) {
				System.out.println("You are " + playerName + ". A mover of words and a speaker in dreams.");
				//Finalizing the stats for the character
				int strFinal = str1;
				int dexFinal = dex1 + 1;
				int conFinal = con1;
				int intFinal = int1;
				int wisFinal = wis1;
				int chaFinal = cha1 + 1;
				
				int statModifier;
				
				if (dexFinal % 2 == 0){
					statModifier = ((dexFinal - 10) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				} else 
					statModifier = ((dexFinal - 11) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
					
			} else if (playerArchClass == 3) {
				System.out.println("You are " + playerName + ". A kin to all blades who seek a darker path.");
				//Finalizing the stats for the character
				int strFinal = str1;
				int dexFinal = dex1 + 2;
				int conFinal = con1;
				int intFinal = int1;
				int wisFinal = wis1;
				int chaFinal = cha1;
				
				int statModifier;
				
				if (dexFinal % 2 == 0){
					statModifier = ((dexFinal - 10) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				} else 
					statModifier = ((dexFinal - 11) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
			}
		}

		private static void playerClassWarrior(String playerName, 
				int str1, int dex1, int con1, int int1, int wis1, int cha1) {
			//custom method for establishing a warrior-based class
			Scanner classInputWarrior = new Scanner(System.in);
			System.out.println("You are a warrior. A hero of strength and a progenitor of might." +
								"\nWhat is your honor?");
			System.out.println("Guardian (1), Barbarian (2), Reaver (3)");
			
			int playerArchClass = classInputWarrior.nextInt();
			
			if (playerArchClass == 1) {
				System.out.println("You are " + playerName + ". You are a protector of the innocent and a lawful upholder.");
				//Finalizing the stats for the character
				int strFinal = str1 + 1;
				int dexFinal = dex1;
				int conFinal = con1 + 1;
				int intFinal = int1;
				int wisFinal = wis1;
				int chaFinal = cha1;
				
				int statModifier;
				
				if (strFinal % 2 == 0){
					statModifier = ((strFinal - 10) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				} else 
					statModifier = ((strFinal - 11) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				
			} else if (playerArchClass == 2) {
				System.out.println("You are " + playerName + ". You are a free spirit and a wrathful watcher.");
				//Finalizing the stats for the character
				int strFinal = str1 + 2;
				int dexFinal = dex1;
				int conFinal = con1;
				int intFinal = int1;
				int wisFinal = wis1;
				int chaFinal = cha1;
				
				int statModifier;
				
				if (strFinal % 2 == 0){
					statModifier = ((strFinal - 10) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				} else 
					statModifier = ((strFinal - 11) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				
			} else if (playerArchClass == 3) {
				System.out.println("You are " + playerName + ". You are a skilled shot and a weary hunter.");
				//Finalizing the stats for the character
				int strFinal = str1 + 1;
				int dexFinal = dex1 + 1;
				int conFinal = con1;
				int intFinal = int1;
				int wisFinal = wis1;
				int chaFinal = cha1;
				
				int statModifier;
				
				if (strFinal % 2 == 0){
					statModifier = ((strFinal - 10) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				} else 
					statModifier = ((strFinal - 11) / 2);
					charInformation(strFinal, dexFinal, conFinal, intFinal, wisFinal, chaFinal, statModifier);
				
				
			}
		}
		private static void charInformation(int strFinal, int dexFinal, int conFinal, int intFinal, int wisFinal, int chaFinal, int statModifier) {
			System.out.println("Your Strength Score is: " + strFinal);
			System.out.println("Your Dexterity Score is: " + dexFinal);
			System.out.println("Your Constitution Score is: " + conFinal);
			System.out.println("Your Intelligence Score is: " + intFinal);
			System.out.println("Your Wisdom Score is: " + wisFinal);
			System.out.println("Your Charisma Score is: " + chaFinal);
			System.out.println("Your Attack Modifier is: " + statModifier);
		}
		
}
