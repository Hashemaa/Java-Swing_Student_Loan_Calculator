/**
 * Program Name: HA_LoanPayable.java
 * Purpose: To hold public final static variables and abstract methods.
 * Coder: Hashem Abou Ahmad	-	0961218
 * Date: Aug 4, 2020
 */

public interface HA_LoanPayable {

	double ANNUAL_RATE_TO_MONTHLY_RATE = 1.0 / 1200.0;


	/**
	 * <p><b>Method Name:</b> calculateLoanPayment()
	 * <p><b>Purpose:</b> An abstract method that will be implemented in StudentLoanApp.java for calculation purposes.
	 * <p><b>Accepts:</b> Two double parameters, and one integer parameter.
	 * <p><b>Returns:</b> A double.
	 * <p><b>Date:</b> August 4, 2020
	 */
	double calculateLoanPayment(double amount, double rate, int amortization);
}//End of interface.