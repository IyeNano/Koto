import java.util.Scanner;
import java.util.Arrays;
public class Exercise7_35 {
	public static void main(String[] args) {
		/*  Hangman game but instead of Chantz's stick figure dongle,
		 *  the sex jokes are the words themselves. The main game's baseline code was taken
		 *  from Alexander when dealing with a similar problem here:
		 *  http://codereview.stackexchange.com/questions/95426/very-simple-hangman-game
		 *  
		 *  I took his code and made it work better with arrays and added some functionality he lacked
		 *  like a play again with a new word feature. Also to make it comedic in classic Jeremy fashion,
		 *  the entire array list of words are curse words/sex euphemisms to compliment Chantz's "hungman"
		 *  version of the game. 
		 */
		
		
		//Array list of words
		String[] words = {"arse", "ass", "asshole", "bastard", "bitch", "bollocks", 
						"crap", "cunt", "damn", "goddamn", "hell", "motherfucker", 
						"shit", "tits", "fuck"};
		
		//Introduction to the user
		System.out.println("Welcome to Curse Word Hangman!");
		
		//Custom Method starting the game
		gameMethod(words);
		
    }
	private static void playAgainMethod(String[] words) {
		// The Custom Method to prompt the user to play again
		
		//Scanner and input string variable
		Scanner replayInput = new Scanner(System.in);
		String continueChoice1 = replayInput.next();
		
		//Determining user choice to see if they want to play again or not
		if ((continueChoice1.equalsIgnoreCase("N")) || 
				(continueChoice1.equalsIgnoreCase("No")) || 
				(continueChoice1.equalsIgnoreCase("Nay"))) {
			System.out.println("Thanks for playing!");
		} else if ((continueChoice1.equalsIgnoreCase("Y")) || 
					(continueChoice1.equalsIgnoreCase("Yes")) || 
					(continueChoice1.equalsIgnoreCase("Yarr"))) {
			gameMethod(words);
		}
		
	}
	private static void gameMethod(String[] words) {
        // Pick random index of words array
        int randomWordNumber = (int) (Math.random() * words.length);
        // Create an array to store already entered letters
        char[] enteredLetters = new char[words[randomWordNumber].length()];
        int triesCount = 0;
        boolean wordIsGuessed = false;
        do {
        // infinitely iterate through cycle as long as enterLetter returns true
        // if enterLetter returns false that means user guessed all the letters
        // in the word e. g. no asterisks were printed by printWord
        switch (enterLetter(words[randomWordNumber], enteredLetters)) {
            case 0:
                triesCount++;
                break;
            case 1:
                triesCount++;
                break;
            case 2:
                break;
            case 3:
                wordIsGuessed = true;
                break;
        }
        } while (! wordIsGuessed);
        System.out.println("\nThe word is " + words[randomWordNumber]);
        System.out.println("You missed " + (triesCount -findEmptyPosition(enteredLetters)) +
            " time(s)");
        
        //Prompt user to play again and goes to the custom method that loops the game
        System.out.println("Play again? (Y/N)");
		playAgainMethod(words);
    }

    /* Hint user to enter a guess letter,
    returns 0 if letter entered is not in the word (counts as try),
    returns 1 if letter were entered 1st time (counts as try),
    returns 2 if already guessed letter was REentered,
    returns 3 if all letters were guessed */
    public static int enterLetter(String word, char[] enteredLetters)    {
        System.out.print("(Guess) Enter a letter in word ");
        // If-clause is true if no asterisks were printed so
        // word is successfully guessed
        if (! printWord(word, enteredLetters))
            return 3;
        System.out.print(" > ");
        Scanner input = new Scanner(System.in);
        int emptyPosition = findEmptyPosition(enteredLetters);
        char userInput = input.nextLine().charAt(0);
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println(userInput + " is already in the word");
            return 2;
        }
        else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            return 1;
        }
        else {
            System.out.println(userInput + " is not in the word");
            return 0;
            }
    }

    /* Print word with asterisks for hidden letters, returns true if
    asterisks were printed, otherwise return false */
    public static boolean printWord(String word, char[] enteredLetters) {
        // Iterate through all letters in word
        boolean asteriskPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            // Check if letter already have been entered bu user before
            if (inEnteredLetters(letter, enteredLetters))
                System.out.print(letter); // If yes - print it
            else {
                System.out.print('*');
                asteriskPrinted = true;
            }
        }
        return asteriskPrinted;
    }

    /* Check if letter is in enteredLetters array */
    public static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }

    /* Find first empty position in array of entered letters (one with code \u0000) */
    public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000') i++;
        return i;

	}
    
}