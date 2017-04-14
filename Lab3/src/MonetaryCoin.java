//********************************************************************
//  MonetaryCoin.java       
//********************************************************************

/* Code taken from inziladun here: http://www.programmingforums.org/post247609.html
 * Code edited for the sake of personal use. All original code is not mine.
 */

public class MonetaryCoin extends Coin {

	protected double value; // this is for dimes (.10), quarters (.25), etc

	MonetaryCoin(int value) {

		this.value = value;
	}

	public double getValue() { // we need just to get the value, a coin cannot change its value !
		return value;

	}

}