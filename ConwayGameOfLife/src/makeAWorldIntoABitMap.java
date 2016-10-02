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


public class makeAWorldIntoABitMap {

	public static void main(String[] args) {
		// declare variables
		int gridHeight = 9;
		int gridWidth = (int)(((((double)gridHeight)/9.0)*16.0));
		int[][] gridWorld = new int[gridHeight][gridWidth];
		int[][] gridWorldToCome = new int[gridHeight][gridWidth];

		double thresholdForLife = 0.7;

		int numberOfFrames = 4;

		for(int frameCounter = 1; frameCounter < numberOfFrames; frameCounter++){

			// initilize world
			gridWorld = customMethodToInitilizeWorld(gridWorld, thresholdForLife);

			System.out.println("This is the old world");
			customMethodToPrintWorld(gridWorld);

			System.out.println("This is the new world");
			gridWorldToCome = customMethodToInitilizeWorld(gridWorld, thresholdForLife);

			customMethodToPrintWorld(gridWorldToCome);


			BufferedImage img = map( gridHeight, gridWidth, gridWorld, gridWorldToCome );
			//savePNG( img, "C:/Users/stf320laptop/Desktop/Koto/MAPtestwithDots.bmp" );
			//savePNG( img, "C:/Users/stf320laptop/Desktop/Koto/MAPtestwithDots.bmp" );
			// savePNG( img, "MAPtestwithDots.bmp" );
			// savePNG( img, "/MAPtestwithDots.bmp" );
			// savePNG( img, "//MAPtestwithDots.bmp" );
			//savePNG( img, "./MAPtestwithDots.bmp" );

			// This line works in the other program, but for now, we seem to be having some other issue.
			savePNG( img, "/Users/stf320laptop/Desktop/Koto/MapTestColor_" +frameCounter +  ".bmp" );

			//http://mindprod.com/jgloss/jpegencoder.html
			//ImageIO.write( aBufferedImage, "JPEG" /* format desired */, new File( "snap.jpg" ) /* target */ );
		}
	}

	private static BufferedImage map( int sizeX, int sizeY, int[][] gridWorld, int[][] gridWorldToCome ){
		final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
		for (int x = 0; x < sizeX; x++){
			for (int y = 0; y < sizeY; y++){

				/* 
				 * trying to find out that I had my addresses switched.
				 *
				// old line
				res.setRGB(x, y, Color.BLACK.getRGB() );
				// new line
				System.out.println("Check if it is alive.");
				System.out.println("Our row is: " + x);
				System.out.println("Our column is: " + y);
				if(0 == gridWorld[x][y] ){
					//res.setRGB(x, y, Color.WHITE.getRGB() );
					res.setRGB(x, y, Color.WHITE.getRGB() );
				} 
				System.out.println("Done checking if it is alive.");

				 */

				//res.setRGB(x, y, Color.BLACK.getRGB() );
				// it was dead and is still dead
				if(0 == gridWorld[x][y] ) {
					if(0 == gridWorldToCome[x][y] ){
						//res.setRGB(x, y, Color.WHITE.getRGB() );
						res.setRGB(x, y, Color.BLACK.getRGB() );
					}

				} 

				// it was dead, but now is alive
				if (0 == gridWorld[x][y]){
					System.out.println("It was dead.");
					System.out.println("x is: " + x);
					System.out.println("y is: " + y);
					System.out.println(" and our new world value is: " + gridWorldToCome[x][y]);
					if(1 == gridWorldToCome[x][y]){
						//res.setRGB(x, y, Color.ORANGE.getRGB() );
						System.out.println("We should have a green block.");
						res.setRGB(x, y, Color.GREEN.getRGB() );
					}
				} 

				// it was alive, but now is dead
				if (1 == gridWorld[x][y]  && 0 == gridWorldToCome[x][y]){
					//res.setRGB(x, y, Color.PINK.getRGB() );
					res.setRGB(x, y, Color.RED.getRGB() );
				} 



				// it was a live and stayed alive
				if (1 == gridWorld[x][y]  && 1 == gridWorldToCome[x][y]){
					res.setRGB(x, y, Color.BLUE.getRGB() );
				} 


			}
		}
		return res;
	}

	private static void savePNG( final BufferedImage bi, final String path ){
		try {
			RenderedImage rendImage = bi;
			// MAPtestwithDots.bmp
			// ImageIO.write(rendImage, "bmp", new File(path));
			ImageIO.write(rendImage, "bmp", new File(path));
			//ImageIO.write(rendImage, "PNG", new File(path));
			//ImageIO.write(rendImage, "jpeg", new File(path));
		} catch ( IOException e) {
			e.printStackTrace();
		}
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

}
