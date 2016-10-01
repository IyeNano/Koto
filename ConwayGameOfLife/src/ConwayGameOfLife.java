
public class ConwayGameOfLife {

	public static void main(String[] args) {
		System.out.println("We are going to take over that \n" +
				"world you are so fond of saying hello to...");

		//For reference to "Conway's Game of Life: 
		// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life"

		// for reference on ideas to visualize:
		// http://www.bay12games.com/dwarves/

		// declare variables
		int gridHeight = 5;
		int gridWidth = 7;
		int[][] gridWorld = new int[gridHeight][gridWidth];
		int[][] gridWorldToCome = new int[gridHeight][gridWidth];

		int numberOfCycles = 3;



		// initilize world
		gridWorld = customMethodToInitilizeWorld(gridWorld);

		// print off the world;
		customMethodToPrintWorld(gridWorld);

		for(int cycleCounter = 1; cycleCounter <= numberOfCycles; cycleCounter++){
			// go through and make the next the worldToCome
			gridWorldToCome = customMethodToUpdateWorld(gridWorld);

			System.out.println("Cycle");
			// update display
			customMethodToPrintWorld(gridWorldToCome);

			// copy the update and make Current World = worldToCome
			gridWorld = gridWorldToCome;
			
			
		}

		// after a thousand generations, show what the world was and what it has become.
		customMethodToPrintWorld(gridWorld);

	}

	public static int[][] customMethodToInitilizeWorld(int[][] gridWorld) {

		double randomLifeStart = 0.0;

		int gridHeight = gridWorld.length;
		System.out.println("Our array height is: " + gridHeight);
		int gridWidth = gridWorld[0].length;
		System.out.println("Our array width is: " + gridWidth);


		for(int heightCounter = 0; heightCounter <gridHeight; heightCounter++){
			for(int widthCounter = 0; widthCounter<gridWidth; widthCounter++){
				randomLifeStart = Math.random();
				if(0.3>randomLifeStart){
					gridWorld[heightCounter][widthCounter] = 1;
				}else{
					gridWorld[heightCounter][widthCounter] = 0;
				}
				System.out.print("\t" + gridWorld[heightCounter][widthCounter]);
			}
			System.out.println();
		}
		System.out.println("The world has life.");

		return gridWorld;

	}
	public static void customMethodToPrintWorld(int[][] gridWorld) {
		int gridHeight = gridWorld.length;
		//System.out.println("Our array Size 1 is: " + gridHeight);
		int gridWidth = gridWorld[0].length;
		//System.out.println("Our array Size 2 is: " + gridWidth);

		// printing off the world:
		System.out.println("Let's see the world");
		for(int heightCounter = 0; heightCounter <gridHeight; heightCounter++){
			for(int widthCounter = 0; widthCounter<gridWidth; widthCounter++){
				System.out.print("\t" + gridWorld[heightCounter][widthCounter]);
			}
			System.out.println();
		}
		System.out.println("and that is our world.");
	}


	public static int[][] customMethodToUpdateWorld(int[][] gridWorld) {

		int[][] gridWorldToCome = gridWorld;
		//System.out.println("Updating the world custom method call.");
		int gridHeight = gridWorld.length;
		//System.out.println("Our array width is: " + gridHeight);
		int gridWidth = gridWorld[0].length;
		//System.out.println("Our array length is: " + gridWidth);

		int neighborCount = 0;

		// work through the grid
		//System.out.println("Let's update every little life.");
		for(int heightCounter = 0; heightCounter <gridHeight; heightCounter++){
			//System.out.println("Starting a new row.");
			for(int widthCounter = 0; widthCounter<gridWidth; widthCounter++){

				//System.out.println("We are looking at grid location row: " + heightCounter +
					//	" column: " + widthCounter);

				neighborCount = customMethodToCountNeighbors(gridWorld, heightCounter, widthCounter );

				//System.out.println("We have our neighbor count.");

				if(1 == gridWorldToCome[heightCounter][widthCounter]){
					if(2 > neighborCount){
						gridWorldToCome[heightCounter][widthCounter] = 0;
					}

					if(2 == neighborCount || 3 == neighborCount){
						gridWorldToCome[heightCounter][widthCounter] = 1;
					}
					if(3 < neighborCount){
						gridWorldToCome[heightCounter][widthCounter] = 0;
					}
				} else {
					if(3 == neighborCount){
						gridWorldToCome[heightCounter][widthCounter] = 1;
					}
				}


				//System.out.print("\t" + gridWorld[heightCounter][widthCounter]);
			}
			//System.out.println();
		}
		//System.out.println("and that is our UPDATED world.");
		return gridWorldToCome;
	}


	public static int customMethodToCountNeighbors(int[][] gridWorld, int heightCounter, int widthCounter) {
		int neighborCount = 0;

		//System.out.println("Counting Neighbors.");
		int gridHeight = gridWorld.length;
		//System.out.println("Our array width is: " + gridHeight);
		int gridWidth = gridWorld[0].length;
		//System.out.println("Our array length is: " + gridWidth);

		if(heightCounter != 0 && heightCounter != (gridHeight-1)){
			if(widthCounter!=0 && widthCounter != (gridWidth-1)){
			//	System.out.println("This is a normal case.");

				//System.out.println("add first column of neighbors");

				neighborCount = gridWorld[heightCounter -1 ][widthCounter -1] +
						gridWorld[heightCounter -0 ][widthCounter -1] +
						gridWorld[heightCounter +1 ][widthCounter -1];

				//System.out.println("add second column of neighbors");

				neighborCount = neighborCount + 
						gridWorld[heightCounter -1 ][widthCounter -0] +
						//gridWorld[heightCounter -0 ][widthCounter -0] +
						gridWorld[heightCounter +1 ][widthCounter -0];

				//System.out.println("add third column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[heightCounter -1 ][widthCounter +1] +
						gridWorld[heightCounter -0 ][widthCounter +1] +
						gridWorld[heightCounter +1 ][widthCounter +1];
			} else {
				//System.out.println("This is a boundry case for width.");
			}
		} else {
			//System.out.println("This is a boundry case for height.");
		}

		//System.out.println("Let's look at the boundry conditions.");

		if( 0 == heightCounter){
			//System.out.println("Looking at the top row.");
			if(widthCounter!=0 && widthCounter != (gridWidth-1)){

				//System.out.println("add first column of neighbors");

				neighborCount = gridWorld[gridHeight-1 ][widthCounter -1] +
						gridWorld[heightCounter -0 ][widthCounter -1] +
						gridWorld[heightCounter +1 ][widthCounter -1];

				//System.out.println("add second column of neighbors");

				neighborCount = neighborCount + 
						gridWorld[gridHeight-1 ][widthCounter -0] +
						//gridWorld[heightCounter -0 ][widthCounter -0] +
						gridWorld[heightCounter +1][widthCounter -0];

				//System.out.println("add third column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[gridHeight-1 ][widthCounter +1] +
						gridWorld[heightCounter -0 ][widthCounter +1] +
						gridWorld[heightCounter +1 ][widthCounter +1];
			} 
		} 


		if(heightCounter == (gridHeight-1)){
			//System.out.println(" Looking at the bottom row.");
			if(widthCounter!=0 && widthCounter != (gridWidth-1)){
				//System.out.println("add first column of neighbors");

				neighborCount = gridWorld[heightCounter -1 ][widthCounter -1] +
						gridWorld[heightCounter -0 ][widthCounter -1] +
						gridWorld[0 ][widthCounter -1];

				//System.out.println("add second column of neighbors");

				neighborCount = neighborCount + 
						gridWorld[heightCounter -1 ][widthCounter -0] +
						//gridWorld[heightCounter -0 ][widthCounter -0] +
						gridWorld[0 ][widthCounter -0];

				//System.out.println("add third column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[heightCounter -1 ][widthCounter +1] +
						gridWorld[heightCounter -0 ][widthCounter +1] +
						gridWorld[0 ][widthCounter +1];
			} else {
				//System.out.println("This is a boundry case for width.");
			}
		} else {
			//System.out.println("This is a boundry case for height.");
		}

		//System.out.println("Our neighbor count is: " + neighborCount);

		return neighborCount;
	}
}
