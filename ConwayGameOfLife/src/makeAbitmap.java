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


public class makeAbitmap {
	public static void main(String[] args) {
		// old line
		//BufferedImage img = map( 320, 160 );
		// new line
		BufferedImage img = map( 1920, 1080 );
		// original code:
		//savePNG( img, "C:/Java_Dev/test.bmp" );
		// new location:
		// C:\Users\LAB\Desktop\Koto
		savePNG( img, "C:/Users/LAB/Desktop/Koto/testWithPinkAndWhiteAndOrangeAndBlueStripes.bmp" );
	}

	private static BufferedImage map( int sizeX, int sizeY ){
		final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
		double randomNumberToSetColor = Math.random();
		for (int x = 0; x < sizeX; x++){
			if(x%20 == 0){
				randomNumberToSetColor = Math.random();
			}
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


}
