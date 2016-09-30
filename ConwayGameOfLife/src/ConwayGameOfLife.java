
public class ConwayGameOfLife {

	public static void main(String[] args) {
		System.out.println("We are going to take over that \n" +
				"world you are so fond of saying hello to...");

		//For reference to "Conway's Game of Life: 
		// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life"

		// declare variables
		int[][] gridWorld = new int[5][5];

		double randomLifeStart = 0.0;

		// initilize world

		for(int i = 0; i <5; i++){
			for(int j = 0; j<5; j++){
				randomLifeStart = Math.random();
				if(0.3>randomLifeStart){
					gridWorld[i][j] = 1;
				}else{
					gridWorld[i][j] = 0;
				}
			}
		}
		System.out.println("The world has life.");

		// set up a for loop 

		// go through and make the next the worldToCome

		// update display

		// copy the update and make Current World = worldToCome

		// after a thousand generations, show what the world was and what it has become.

	}

}
