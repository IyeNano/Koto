/*
 * This is a java implementation of Conway's game of life.
 */

// showing data as an image.
// from:
//http://www.java2s.com/Tutorials/Java/Graphics_How_to/Image/Create_BMP_format_image.htm
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
/*from w w w . j a  v a2  s. c  o m*/
import javax.imageio.ImageIO;

public class ConwayGameOfLife {

	public static void main(String[] args) {

		long startTimeMs = System.currentTimeMillis( );
		System.out.println("We are going to take over that \n" +
				"world you are so fond of saying hello to...");

		//For reference to "Conway's Game of Life: 
		// https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life"

		// for reference on ideas to visualize:
		// http://www.bay12games.com/dwarves/

		// declare variables
		int gridHeight = 60000;
		int gridWidth = 5000;
		int[][] gridWorld = new int[gridHeight][gridWidth];
		int[][] gridWorldToCome = new int[gridHeight][gridWidth];


		double thresholdForLife = 0.7;
		int numberOfCycles = 5;
		int underPopulation = 2; 
		int overPopulation = 3;



		// initilize world
		gridWorld = customMethodToInitilizeWorld(gridWorld, thresholdForLife);

		System.out.println("The world has life.");


		// print off the world;
		//customMethodToPrintWorld(gridWorld);
		System.out.println("and that is our initial world.");


		for(int lifeCycleCounter = 1; lifeCycleCounter <= numberOfCycles; lifeCycleCounter++){

			// go through and make the next the worldToCome
			gridWorldToCome = customMethodToUpdateWorld(gridWorld, underPopulation, overPopulation);

			System.out.println("Cycle is " + lifeCycleCounter);
			// update display
			//customMethodToPrintWorld(gridWorldToCome);

			// copy the update and make Current World = worldToCome
			gridWorld = gridWorldToCome;

		}

		// after set number of generations, show what the world was and what it has become.
		System.out.println("We have completed lives: " +(numberOfCycles) + " and this is our final world.");
		//customMethodToPrintWorld(gridWorld);

		long taskTimeMs  = 
				System.currentTimeMillis( ) - startTimeMs;
		System.out.println("This took " 
				+ taskTimeMs/1000 + " seconds.");

	}

	public static int[][] customMethodToInitilizeWorld(int[][] gridWorld, double thresholdForLife) {

		double randomLifeStart = 0.0;

		int gridHeight = gridWorld.length;
		//System.out.println("Our array height is: " + gridHeight);
		int gridWidth = gridWorld[0].length;
		//System.out.println("Our array width is: " + gridWidth);


		for(int heightCounter = 0; heightCounter <gridHeight; heightCounter++){
			for(int widthCounter = 0; widthCounter<gridWidth; widthCounter++){
				randomLifeStart = Math.random();
				if(thresholdForLife<randomLifeStart){
					gridWorld[heightCounter][widthCounter] = 1;
				}else{
					gridWorld[heightCounter][widthCounter] = 0;
				}
				//System.out.print("\t" + gridWorld[heightCounter][widthCounter]);
			}
			//System.out.println();
		}


		return gridWorld;

	}
	public static void customMethodToPrintWorld(int[][] gridWorld) {
		int gridHeight = gridWorld.length;
		//System.out.println("Our array Size 1 is: " + gridHeight);
		int gridWidth = gridWorld[0].length;
		//System.out.println("Our array Size 2 is: " + gridWidth);

		// printing off the world:
		//System.out.println("Let's see the world");
		for(int heightCounter = 0; heightCounter <gridHeight; heightCounter++){
			for(int widthCounter = 0; widthCounter<gridWidth; widthCounter++){
				System.out.print("\t" + gridWorld[heightCounter][widthCounter]);
			}
			System.out.println();
		}

	}


	public static int[][] customMethodToUpdateWorld(int[][] gridWorld, int underPopulation, int overPopulation) {

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

				/* 
				 * This is a good set of rules if you are only counting 4 neighbors.
				 * However, if you want to count 8, you need to set the limits a little differently.


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
				 */



				if(1 == gridWorldToCome[heightCounter][widthCounter]){
					if(underPopulation > neighborCount){
						gridWorldToCome[heightCounter][widthCounter] = 0;
					}

					if(underPopulation < neighborCount &&  neighborCount < overPopulation){
						gridWorldToCome[heightCounter][widthCounter] = 1;
					}
					if(overPopulation < neighborCount){
						gridWorldToCome[heightCounter][widthCounter] = 0;
					}
				} else {
					if( underPopulation <neighborCount){
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

			} 
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

			} 
		} 

		if(heightCounter != 0 && heightCounter != (gridHeight-1)){
			if(0 == widthCounter){
				//System.out.println("This on the left side, but not at the top or bottom.");

				//System.out.println("add first column of neighbors");
				neighborCount = gridWorld[heightCounter -1 ][(gridWidth-1)] +
						gridWorld[heightCounter -0 ][(gridWidth-1)] +
						gridWorld[heightCounter +1 ][(gridWidth-1)];

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
			} 
		}

		if(heightCounter != 0 && heightCounter != (gridHeight-1)){
			if(widthCounter == (gridWidth-1)){
				//System.out.println("This is the left column.");

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
						gridWorld[heightCounter -1 ][0] +
						gridWorld[heightCounter -0 ][0] +
						gridWorld[heightCounter +1 ][0];
			} 
		} 

		if(0 == heightCounter){
			if(0 == widthCounter){
				//System.out.println("This is the upper left corner. \n (1 of 4)");

				//System.out.println("add first column of neighbors");
				neighborCount = gridWorld[(gridHeight-1) ][(gridWidth-1)] +
						gridWorld[heightCounter -0 ][(gridWidth-1)] +
						gridWorld[heightCounter +1 ][(gridWidth-1)];

				//System.out.println("add second column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[(gridHeight-1) ][widthCounter -0] +
						//gridWorld[heightCounter -0 ][widthCounter -0] +
						gridWorld[heightCounter +1 ][widthCounter -0];

				//System.out.println("add third column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[(gridHeight-1)][widthCounter +1] +
						gridWorld[heightCounter -0 ][widthCounter +1] +
						gridWorld[heightCounter +1 ][widthCounter +1];
			} 
		}

		if(0 == heightCounter){
			if(widthCounter == (gridWidth-1)){
				//System.out.println("This is the upper right corner. \n (2 of 4)");

				//System.out.println("add first column of neighbors");
				neighborCount = gridWorld[(gridHeight-1)][widthCounter -1] +
						gridWorld[heightCounter -0 ][widthCounter -1] +
						gridWorld[heightCounter +1 ][widthCounter -1];

				//System.out.println("add second column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[(gridHeight-1)][widthCounter -0] +
						//gridWorld[heightCounter -0 ][widthCounter -0] +
						gridWorld[heightCounter +1 ][widthCounter -0];

				//System.out.println("add third column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[(gridHeight-1)][0] +
						gridWorld[heightCounter -0 ][0] +
						gridWorld[heightCounter +1 ][0];
			} 
		} 

		if(heightCounter == (gridHeight-1)){
			if(0 == widthCounter){
				//System.out.println("This is the lower left corner. \n (3 of 4)");

				//System.out.println("add first column of neighbors");
				neighborCount = gridWorld[heightCounter -1 ][(gridWidth-1)] +
						gridWorld[heightCounter -0 ][(gridWidth-1)] +
						gridWorld[0 ][(gridWidth-1)];

				//System.out.println("add second column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[heightCounter -1 ][widthCounter -0] +
						//gridWorld[heightCounter -0 ][widthCounter -0] +
						gridWorld[0 ][widthCounter -0];

				//System.out.println("add third column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[heightCounter -1 ][widthCounter +1] +
						gridWorld[heightCounter -0 ][widthCounter +1] +
						gridWorld[0][widthCounter +1];
			} 
		} 

		if(heightCounter == (gridHeight-1)){
			if(widthCounter == (gridWidth-1)){
				//System.out.println("This is the lower right corner. \n (4 of 4)");

				//System.out.println("add first column of neighbors");
				neighborCount = gridWorld[heightCounter -1 ][widthCounter -1] +
						gridWorld[heightCounter -0 ][widthCounter -1] +
						gridWorld[0 ][widthCounter -1];

				//System.out.println("add second column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[heightCounter -1 ][widthCounter -0] +
						//gridWorld[heightCounter -0 ][widthCounter -0] +
						gridWorld[0][widthCounter -0];

				//System.out.println("add third column of neighbors");
				neighborCount = neighborCount + 
						gridWorld[heightCounter -1 ][0] +
						gridWorld[heightCounter -0 ][0] +
						gridWorld[0][0];
			} 

		} 


		//System.out.println("Our neighbor count is: " + neighborCount);

		return neighborCount;
	}
}
