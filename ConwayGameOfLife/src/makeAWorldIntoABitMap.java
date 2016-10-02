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

		// initilize world
		gridWorld = customMethodToInitilizeWorld(gridWorld, thresholdForLife);

		System.out.println("This is the old world");
		customMethodToPrintWorld(gridWorld);

		System.out.println("This is the new world");
		gridWorldToCome = customMethodToInitilizeWorld(gridWorld, thresholdForLife);

		customMethodToPrintWorld(gridWorldToCome);


		BufferedImage img = map( gridWidth, gridHeight, gridWorld, gridWorldToCome );
		savePNG( img, "C:/Users/LAB/Desktop/Koto/MAPtestWithPinkAndWhiteAndOrangeAndBlueStripes.bmp" );

	}

	private static BufferedImage map( int sizeX, int sizeY, int[][] gridWorld, int[][] gridWorldToCome ){
		final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
		double randomNumberToSetColor = Math.random();
		for (int x = 0; x < sizeX; x++){
			for (int y = 0; y < sizeY; y++){
				// old line
				//res.setRGB(x, y, Color.WHITE.getRGB() );
				// new line


				if(0.25 > randomNumberToSetColor){
					res.setRGB(x, y, Color.WHITE.getRGB() );
				} else if (0.25 <= randomNumberToSetColor && 0.5 > randomNumberToSetColor){
					res.setRGB(x, y, Color.PINK.getRGB() );
				} else if (0.5 <= randomNumberToSetColor && 0.75 > randomNumberToSetColor){
					res.setRGB(x, y, Color.ORANGE.getRGB() );
				} else if (0.75 <= randomNumberToSetColor){
					res.setRGB(x, y, Color.BLUE.getRGB() );
				} 

			}
		}
		return res;
	}

	private static void savePNG( final BufferedImage bi, final String path ){
		try {
			RenderedImage rendImage = bi;
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
