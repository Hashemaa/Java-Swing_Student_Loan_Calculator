
/**
 * Program Name: Student.java
 * Purpose: To hold Students' attributes.
 * Coder: Hashem Abou Ahmad	-	0961218
 * Date: Aug 4, 2020
 */

public class Student {

	//Global variables.
	private String studentID, surname, middleName, firstName, aptNumber, streetNumber, streetName, city, province, postalCode;

	private double cslLoanAmount, oslLoanAmount;


	//Constructor.
	public Student(String studentID, String surname, String middleName, String firstName, String aptNumber, String streetNumber, String streetName, String city,
			String province, String postalCode, double cslLoanAmount, double oslLoanAmount) {

		this.studentID = studentID;
		this.surname = surname;
		this.middleName = middleName;
		this.firstName = firstName;
		this.aptNumber = aptNumber;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;

		this.cslLoanAmount = cslLoanAmount;
		this.oslLoanAmount = oslLoanAmount;

	}//End of multi-arg constructor.


	/**
	 * <p><b>Method Name: toString()</b> 
	 * <p><b>Purpose: Overrides the toString() method to outputs Students' information.</b>
	 * <p><b>Accepts: Nothing.</b> 
	 * <p><b>Returns: A String.</b> 
	 * <p><b>Date:</b> Jul 31, 2020
	 */
	@Override
	public String toString() {

		return "Student Name: " + this.getSurname() + ", " + this.firstName + " " + this.middleName + "\nStudent Number: " + this.getStudentID() + "\nCSL Amount is "
				+ this.getCslLoanAmount() + "\nOSL Amount is: " + this.getOslLoanAmount();

	}//End of toString() method.

	//Getters.
	public String getStudentID() { return this.studentID; }
	public String getSurname() { return this.surname; }
	public String getMiddleName() { return this.middleName; }
	public String getFirstName() { return this.firstName; }
	public String getAptNumber() { return this.aptNumber; }
	public String getStreetNumber() { return this.streetNumber; }
	public String getStreetName() { return this.streetName; }
	public String getCity() { return this.city; }
	public String getProvince() { return this.province; }
	public String getPostalCode() { return this.postalCode; }

	public double getCslLoanAmount() { return this.cslLoanAmount; }
	public double getOslLoanAmount() { return this.oslLoanAmount; }
	//End of Getter methods.


	//Setters.
	public void setSurname(String text) { this.surname = text; }
	public void setMiddleName(String text) { this.middleName = text; }
	public void setFirstName(String text) { this.firstName = text; }
	public void setAptNumber(String text) { this.aptNumber = text; }
	public void setStreetNumber(String text) { this.streetNumber = text; }
	public void setStreetName(String text) { this.streetName = text; }
	public void setCity(String text) { this.city = text; }
	public void setProvince(String text) { this.province = text; }
	public void setPostalCode(String text) { this.postalCode = text; }

	public void setCslLoanAmount(double value) { this.cslLoanAmount = value; }
	public void setOslLoanAmount(double value) { this.oslLoanAmount = value; }
	//End of Setters.

}//End of Student class.
