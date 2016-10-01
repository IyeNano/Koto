
public class ConwayGameOfLife {

	public static void main(String[] args) {
		System.out.println("We are going to take over that \n" +
				"world you are so fond of saying hello to...");

		//For reference to "Conway's Game of Life: 
		// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life"

		// for reference on ideas to visualize:
		// http://www.bay12games.com/dwarves/

		// declare variables
		int gridWidth = 5;
		int gridHeight = 7;
		int[][] gridWorld = new int[gridWidth][gridHeight];
		int[][] gridWorldToCome = new int[gridWidth][gridHeight];

		double randomLifeStart = 0.0;

		// initilize world

		for(int widthCounter = 0; widthCounter <gridWidth; widthCounter++){
			for(int heightCounter = 0; heightCounter<gridHeight; heightCounter++){
				randomLifeStart = Math.random();
				if(0.3>randomLifeStart){
					gridWorld[widthCounter][heightCounter] = 1;
				}else{
					gridWorld[widthCounter][heightCounter] = 0;
				}
				System.out.print("\t" + gridWorld[widthCounter][heightCounter]);
			}
			System.out.println();
		}
		System.out.println("The world has life.");

		customMethodToPrintWorld(gridWorld);

		// go through and make the next the worldToCome
		gridWorldToCome = customMethodToUpdateWorld(gridWorld);

		// update display

		// copy the update and make Current World = worldToCome

		// after a thousand generations, show what the world was and what it has become.

	}
	public static void customMethodToPrintWorld(int[][] gridWorld) {
		int gridWidth = gridWorld.length;
		System.out.println("Our array Size 1 is: " + gridWidth);
		int gridHeight = gridWorld[0].length;
		System.out.println("Our array Size 2 is: " + gridHeight);

		// printing off the world:
		System.out.println("Let's see the world");
		for(int widthCounter = 0; widthCounter <gridWidth; widthCounter++){
			for(int heightCounter = 0; heightCounter<gridHeight; heightCounter++){
				System.out.print("\t" + gridWorld[widthCounter][heightCounter]);
			}
			System.out.println();
		}
		System.out.println("and that is our world.");
	}

	public static int[][] customMethodToUpdateWorld(int[][] gridWorld) {

		int[][] gridWorldToCome = gridWorld;
		System.out.println("Updating the world.");
		int gridWidth = gridWorld.length;
		System.out.println("Our array width is: " + gridWidth);
		int gridHeight = gridWorld[0].length;
		System.out.println("Our array length is: " + gridHeight);

		int neighborCount = 0;

		// printing off the world:
		System.out.println("Let's see the world");
		for(int widthCounter = 0; widthCounter <gridWidth; widthCounter++){
			for(int heightCounter = 0; heightCounter<gridHeight; heightCounter++){

				neighborCount = customMethodToCountNeighbors(gridWorld, widthCounter, heightCounter );

				if(1 == gridWorldToCome[widthCounter][heightCounter]){
					if(2 > neighborCount){
						gridWorldToCome[widthCounter][heightCounter] = 0;
					}

					if(2 == neighborCount || 3 == neighborCount){
						gridWorldToCome[widthCounter][heightCounter] = 1;
					}
					if(3 < neighborCount){
						gridWorldToCome[widthCounter][heightCounter] = 0;
					}
				} else {
					if(3 == neighborCount){
						gridWorldToCome[widthCounter][heightCounter] = 1;
					}
				}


				System.out.print("\t" + gridWorld[widthCounter][heightCounter]);
			}
			System.out.println();
		}
		System.out.println("and that is our UPDATED world.");
		return gridWorldToCome;
	}
	public static int customMethodToCountNeighbors(int[][] gridWorld, int widthCounter, int heightCounter) {
		int neighborCount = 0;

		System.out.println("Updating the world.");
		int gridWidth = gridWorld.length;
		System.out.println("Our array width is: " + gridWidth);
		int gridHeight = gridWorld[0].length;
		System.out.println("Our array length is: " + gridHeight);

		if(widthCounter != 0 && widthCounter != gridWidth){
			if(heightCounter!=0 && heightCounter != gridHeight){
				System.out.println("This is a normal case.");
				neighborCount = gridWorld[widthCounter -1 ][heightCounter -1] +
						gridWorld[widthCounter -0 ][heightCounter -1] +
						gridWorld[widthCounter +1 ][heightCounter -1] +
						gridWorld[widthCounter -1 ][heightCounter -0] +
						//gridWorld[widthCounter -0 ][heightCounter -0] +
						gridWorld[widthCounter +1 ][heightCounter -0] +
						gridWorld[widthCounter -1 ][heightCounter +1] +
						gridWorld[widthCounter -0 ][heightCounter +1] +
						gridWorld[widthCounter +1 ][heightCounter +1];
			}
		}
		System.out.println("Our neighbor count is: " + neighborCount);

		return neighborCount;
	}
}
