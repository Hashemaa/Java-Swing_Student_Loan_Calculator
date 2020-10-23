/**
 * Program Name: HA_NegativeValueException.java
 * Purpose: To catch a negative value exception if thrown.
 * Coder: Hashem Abou Ahmad	-	0961218
 * Date: Aug 7, 2020
 */

@SuppressWarnings("serial")
public class HA_NegativeValueException extends Exception {

	double convertedNumber, negativeNumber;


	public HA_NegativeValueException(double value) {

		negativeNumber = value;
		convertedNumber = Math.abs(value);

	}//End of constructor.

	@Override
	public String toString() {

		return "Invalid entry, " + negativeNumber + " can not be negative. Will convert " + negativeNumber + " to " + Math.abs(negativeNumber)
				+ " and continue with the calculations.";

	}//End of toString() method.

}//EEnd of HA_NegativeValueException class.
