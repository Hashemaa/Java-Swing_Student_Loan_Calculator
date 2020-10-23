import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * Program Name: StudentLoanApp.java
 * Purpose: A user interface student loan calculator application.
 * Coder: Hashem Abou Ahmad	-	0961218
 * Date: Aug 4, 2020
 */

@SuppressWarnings("serial")
public class StudentLoanApp extends JFrame {
	ArrayList<Student> studentList = new ArrayList<Student>();

	//Global Variables.
	JPanel inputPanel, displayPanel;
	JTextField studentIDInput, surnameInput, middleNameInput, firstNameInput, aptNumberInput, streetNumberInput, streetNameInput, cityInput, provinceInput,
			postalCodeInput, oslLoanAmountInput, cslLoanAmountInput, studentIDOutput, surnameOutput, middleNameOutput, firstNameOutput, aptNumberOutput,
			streetNumberOutput, streetNameOutput, cityOutput, provinceOutput, postalCodeOutput, cslLoanAmountOutput, oslLoanAmountOutput, amortizationInput;
	DecimalFormat format;
	Font labelFont, buttonFont;
	Color labelColor;
	JButton displayButton;
	JLabel cslRequiredLabel, oslRequiredLabel, totalRequiredLabel, totalWithInterestLabel, originalLoanLabel, totalInterestPaidLabel;
	JSpinner interestRateInput;
	JFormattedTextField interestRateTextField;

	int i = 0;


	public StudentLoanApp() {

		//Creates the input form.
		super("Hashem Abou Ahmad - 0961218 - Input Form");
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 10));
		this.getContentPane().setBackground(Color.WHITE);

		JLabel label = new JLabel("This is Hashem's Student Loan Calculator", SwingConstants.CENTER);
		label.setFont(new Font("Agency FB", Font.BOLD, 30));
		label.setForeground(Color.BLACK);
		this.add(label, BorderLayout.NORTH);

		inputPanel = new JPanel(new GridLayout(12, 2, 5, 10));
		labelFont = new Font("Arial", Font.ITALIC, 18);
		labelColor = Color.BLACK;
		JLabel studentIDLabel = new JLabel(" * StudentID: ");
		studentIDLabel.setFont(labelFont);
		studentIDLabel.setForeground(labelColor);
		inputPanel.add(studentIDLabel);
		studentIDInput = new JTextField(null);
		inputPanel.add(studentIDInput);

		JLabel surnameLabel = new JLabel(" * Surname: ");
		surnameLabel.setFont(labelFont);
		surnameLabel.setForeground(labelColor);
		inputPanel.add(surnameLabel);
		surnameInput = new JTextField(null);
		inputPanel.add(surnameInput);

		JLabel middleNameLabel = new JLabel("   Middle name: ");
		middleNameLabel.setFont(labelFont);
		middleNameLabel.setForeground(labelColor);
		inputPanel.add(middleNameLabel);
		middleNameInput = new JTextField(null);
		inputPanel.add(middleNameInput);

		JLabel firstNameLabel = new JLabel(" * First name: ");
		firstNameLabel.setFont(labelFont);
		firstNameLabel.setForeground(labelColor);
		inputPanel.add(firstNameLabel);
		firstNameInput = new JTextField(null);
		inputPanel.add(firstNameInput);

		JLabel aptNumberLabel = new JLabel("   Apartment number: ");
		aptNumberLabel.setFont(labelFont);
		aptNumberLabel.setForeground(labelColor);
		inputPanel.add(aptNumberLabel);
		aptNumberInput = new JTextField(null);
		inputPanel.add(aptNumberInput);

		JLabel streetNumberLabel = new JLabel("   Street number: ");
		streetNumberLabel.setFont(labelFont);
		streetNumberLabel.setForeground(labelColor);
		inputPanel.add(streetNumberLabel);
		streetNumberInput = new JTextField(null);
		inputPanel.add(streetNumberInput);

		JLabel streetNameLabel = new JLabel("   Street name: ");
		streetNameLabel.setFont(labelFont);
		streetNameLabel.setForeground(labelColor);
		inputPanel.add(streetNameLabel);
		streetNameInput = new JTextField(null);
		inputPanel.add(streetNameInput);

		JLabel cityLabel = new JLabel("   City: ");
		cityLabel.setFont(labelFont);
		cityLabel.setForeground(labelColor);
		inputPanel.add(cityLabel);
		cityInput = new JTextField(null);
		inputPanel.add(cityInput);

		JLabel provinceLabel = new JLabel("   Province: ");
		provinceLabel.setFont(labelFont);
		provinceLabel.setForeground(labelColor);
		inputPanel.add(provinceLabel);
		provinceInput = new JTextField(null);
		inputPanel.add(provinceInput);

		JLabel postalCodeLabel = new JLabel("   Postal code: ");
		postalCodeLabel.setFont(labelFont);
		postalCodeLabel.setForeground(labelColor);
		inputPanel.add(postalCodeLabel);
		postalCodeInput = new JTextField(null);
		inputPanel.add(postalCodeInput);

		JLabel cslLoanAmountLabel = new JLabel(" * CSL loan amount: $");
		cslLoanAmountLabel.setFont(labelFont);
		cslLoanAmountLabel.setForeground(labelColor);
		inputPanel.add(cslLoanAmountLabel);
		cslLoanAmountInput = new JTextField(null);
		inputPanel.add(cslLoanAmountInput);

		JLabel oslLoanAmountLabel = new JLabel(" * OSL loan amount: $");
		oslLoanAmountLabel.setFont(labelFont);
		oslLoanAmountLabel.setForeground(labelColor);
		inputPanel.add(oslLoanAmountLabel);
		oslLoanAmountInput = new JTextField(null);
		inputPanel.add(oslLoanAmountInput);

		this.add(inputPanel, BorderLayout.CENTER);

		JPanel submissionPanel = new JPanel(new GridLayout(1, 3, 2, 0));
		buttonFont = new Font("Agency Fb", Font.BOLD, 20);

		JButton clearButton = new JButton("Clear");
		clearButton.setFont(buttonFont);
		clearButton.addActionListener(new clearButtonEvent());
		submissionPanel.add(clearButton);

		JButton saveButton = new JButton("Save data");
		saveButton.setFont(buttonFont);
		saveButton.addActionListener(new saveButtonEvent());
		submissionPanel.add(saveButton);

		displayButton = new JButton("Display");
		displayButton.setFont(buttonFont);
		displayButton.addActionListener(new displayButtonEvent());
		submissionPanel.add(displayButton);

		this.add(submissionPanel, BorderLayout.SOUTH);


		this.setVisible(true);

	}//End of constructor.


	/**
	 * <p><b>Class Name:</b> clearButtonEvent
	 * <p><b>Purpose:</b> To implement ActionListener for the button to clear the list.
	 * <p><b>Date:</b> August 6, 2020
	 */
	private class clearButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			//Resets the values.
			studentIDInput.setText(null);
			surnameInput.setText(null);
			middleNameInput.setText(null);
			firstNameInput.setText(null);
			aptNumberInput.setText(null);
			streetNumberInput.setText(null);
			streetNameInput.setText(null);
			cityInput.setText(null);
			provinceInput.setText(null);
			postalCodeInput.setText(null);
			cslLoanAmountInput.setText(null);
			oslLoanAmountInput.setText(null);

		}//End of actionPerformed() method.

	}//End of clearButtonEvent class.


	/**
	 * <p><b>Class Name:</b> saveButtonEvent
	 * <p><b>Purpose:</b> To implement ActionListener for the button to save the list.
	 * <p><b>Date:</b> August 6, 2020
	 */
	private class saveButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			boolean isValid = runValidation();

			//If isValid is true, add the new record to the student ArrayList.
			if(isValid == true) {
				Student newRecord = new Student(studentIDInput.getText(), surnameInput.getText(), middleNameInput.getText(), firstNameInput.getText(), aptNumberInput
						.getText(), streetNumberInput.getText(), streetNameInput.getText(), cityInput.getText(), provinceInput.getText(), postalCodeInput.getText(), Double
								.parseDouble(cslLoanAmountInput.getText()), Double.parseDouble(oslLoanAmountInput.getText()));
				studentList.add(newRecord);

				JOptionPane.showMessageDialog(inputPanel, "Record saved.");
			}

		}//End of actionPerformed() method.

	}//End of saveButtonEvent class.


	/**
	 * <p><b>Class Name:</b> displayButtonEvent
	 * <p><b>Purpose:</b> To implement ActionListener for the button to clear display the student list.
	 * <p><b>Date:</b> August 6, 2020
	 */
	private class displayButtonEvent extends JFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if(!studentList.isEmpty()) {
				//Creates the display form.
				displayButton.setEnabled(false);
				this.setTitle("Student Records and Repayment Calculation Form");
				this.setLocationRelativeTo(null);
				this.setSize(600, 800);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setLayout(new BorderLayout(0, 10));

				displayPanel = new JPanel(new GridLayout(14, 2, 5, 10));
				displayPanel.setBackground(Color.WHITE);
				JLabel studentIDLabel = new JLabel("   StudentID: ");
				studentIDLabel.setFont(labelFont);
				studentIDLabel.setForeground(labelColor);
				displayPanel.add(studentIDLabel);
				studentIDOutput = new JTextField(studentList.get(i).getStudentID());
				studentIDOutput.setEditable(false);
				displayPanel.add(studentIDOutput);

				JLabel surnameLabel = new JLabel("   Surname: ");
				surnameLabel.setFont(labelFont);
				surnameLabel.setForeground(labelColor);
				displayPanel.add(surnameLabel);
				surnameOutput = new JTextField(studentList.get(i).getSurname());
				surnameOutput.setEditable(false);
				displayPanel.add(surnameOutput);

				JLabel middleNameLabel = new JLabel("   Middle name: ");
				middleNameLabel.setFont(labelFont);
				middleNameLabel.setForeground(labelColor);
				displayPanel.add(middleNameLabel);
				middleNameOutput = new JTextField(studentList.get(i).getMiddleName());
				middleNameOutput.setEditable(false);
				displayPanel.add(middleNameOutput);

				JLabel firstNameLabel = new JLabel("   First name: ");
				firstNameLabel.setFont(labelFont);
				firstNameLabel.setForeground(labelColor);
				displayPanel.add(firstNameLabel);
				firstNameOutput = new JTextField(studentList.get(i).getFirstName());
				firstNameOutput.setEditable(false);
				displayPanel.add(firstNameOutput);

				JLabel aptNumberLabel = new JLabel("   Apartment number: ");
				aptNumberLabel.setFont(labelFont);
				aptNumberLabel.setForeground(labelColor);
				displayPanel.add(aptNumberLabel);
				aptNumberOutput = new JTextField(studentList.get(i).getAptNumber());
				aptNumberOutput.setEditable(false);
				displayPanel.add(aptNumberOutput);

				JLabel streetNumberLabel = new JLabel("   Street number: ");
				streetNumberLabel.setFont(labelFont);
				streetNumberLabel.setForeground(labelColor);
				displayPanel.add(streetNumberLabel);
				streetNumberOutput = new JTextField(studentList.get(i).getStreetNumber());
				streetNumberOutput.setEditable(false);
				displayPanel.add(streetNumberOutput);

				JLabel streetNameLabel = new JLabel("   Street name: ");
				streetNameLabel.setFont(labelFont);
				streetNameLabel.setForeground(labelColor);
				displayPanel.add(streetNameLabel);
				streetNameOutput = new JTextField(studentList.get(i).getStreetName());
				streetNameOutput.setEditable(false);
				displayPanel.add(streetNameOutput);

				JLabel cityLabel = new JLabel("   City: ");
				cityLabel.setFont(labelFont);
				cityLabel.setForeground(labelColor);
				displayPanel.add(cityLabel);
				cityOutput = new JTextField(studentList.get(i).getCity());
				cityOutput.setEditable(false);
				displayPanel.add(cityOutput);

				JLabel provinceLabel = new JLabel("   Province: ");
				provinceLabel.setFont(labelFont);
				provinceLabel.setForeground(labelColor);
				displayPanel.add(provinceLabel);
				provinceOutput = new JTextField(studentList.get(i).getProvince());
				provinceOutput.setEditable(false);
				displayPanel.add(provinceOutput);

				JLabel postalCodeLabel = new JLabel("   Postal code: ");
				postalCodeLabel.setFont(labelFont);
				postalCodeLabel.setForeground(labelColor);
				displayPanel.add(postalCodeLabel);
				postalCodeOutput = new JTextField(studentList.get(i).getPostalCode());
				postalCodeOutput.setEditable(false);
				displayPanel.add(postalCodeOutput);

				JLabel cslLoanAmountLabel = new JLabel("   CSL loan amount: $");
				cslLoanAmountLabel.setFont(labelFont);
				cslLoanAmountLabel.setForeground(labelColor);
				displayPanel.add(cslLoanAmountLabel);
				cslLoanAmountOutput = new JTextField(String.valueOf(studentList.get(i).getCslLoanAmount()));
				cslLoanAmountOutput.setEditable(false);
				displayPanel.add(cslLoanAmountOutput);

				JLabel oslLoanAmountLabel = new JLabel("   OSL loan amount: $");
				oslLoanAmountLabel.setFont(labelFont);
				oslLoanAmountLabel.setForeground(labelColor);
				displayPanel.add(oslLoanAmountLabel);
				oslLoanAmountOutput = new JTextField(String.valueOf(studentList.get(i).getOslLoanAmount()));
				oslLoanAmountOutput.setEditable(false);
				displayPanel.add(oslLoanAmountOutput);

				JLabel interestRateLabel = new JLabel("   Prime Interest Rate: ");
				interestRateLabel.setFont(labelFont);
				interestRateLabel.setForeground(labelColor);
				displayPanel.add(interestRateLabel);
				interestRateInput = new JSpinner(new SpinnerNumberModel(0.00, 0.00, 100.00, 0.25));
				JSpinner.NumberEditor interestRateEditor = (NumberEditor)interestRateInput.getEditor();
				interestRateEditor.getTextField().setHorizontalAlignment(SwingConstants.LEFT);
				format = interestRateEditor.getFormat();
				format.setMinimumFractionDigits(2);
				interestRateTextField = ((JSpinner.DefaultEditor)interestRateInput.getEditor()).getTextField();
				interestRateTextField.setText("0.00");
				interestRateTextField.setEditable(false);
				displayPanel.add(interestRateInput);

				JLabel amortizationLabel = new JLabel("   Amortization Period in months: ");
				amortizationLabel.setFont(labelFont);
				amortizationLabel.setForeground(labelColor);
				displayPanel.add(amortizationLabel);
				amortizationInput = new JTextField(null);
				displayPanel.add(amortizationInput);

				this.add(displayPanel, BorderLayout.NORTH);

				JPanel calculationPanel = new JPanel(new GridLayout(6, 1, 0, 10));
				cslRequiredLabel = new JLabel("   CSL monthly payment: ");
				cslRequiredLabel.setFont(labelFont);
				cslRequiredLabel.setForeground(labelColor);
				calculationPanel.add(cslRequiredLabel);
				oslRequiredLabel = new JLabel("   OSL monthly payment: ");
				oslRequiredLabel.setFont(labelFont);
				oslRequiredLabel.setForeground(labelColor);
				calculationPanel.add(oslRequiredLabel);
				totalRequiredLabel = new JLabel("   Total monthly payment: ");
				totalRequiredLabel.setFont(labelFont);
				totalRequiredLabel.setForeground(labelColor);
				calculationPanel.add(totalRequiredLabel);
				totalWithInterestLabel = new JLabel("   Total payment with interest: ");
				totalWithInterestLabel.setFont(labelFont);
				totalWithInterestLabel.setForeground(labelColor);
				calculationPanel.add(totalWithInterestLabel);
				originalLoanLabel = new JLabel("   Original amount borrowed: ");
				originalLoanLabel.setFont(labelFont);
				originalLoanLabel.setForeground(labelColor);
				calculationPanel.add(originalLoanLabel);
				totalInterestPaidLabel = new JLabel("   Total interest paid: ");
				totalInterestPaidLabel.setFont(labelFont);
				totalInterestPaidLabel.setForeground(labelColor);
				calculationPanel.add(totalInterestPaidLabel);

				this.add(calculationPanel, BorderLayout.CENTER);

				JPanel submissionPanel = new JPanel(new GridLayout(1, 3, 2, 0));
				buttonFont = new Font("Agency Fb", Font.BOLD, 20);

				JButton previousButton = new JButton("Previous");
				previousButton.setFont(buttonFont);
				previousButton.addActionListener(new previousButtonEvent());
				submissionPanel.add(previousButton);

				JButton calculateButton = new JButton("Calculate");
				calculateButton.setFont(buttonFont);
				calculateButton.addActionListener(new calculateButtonEvent());
				submissionPanel.add(calculateButton);

				JButton nextButton = new JButton("Next");
				nextButton.setFont(buttonFont);
				nextButton.addActionListener(new nextButtonEvent());
				submissionPanel.add(nextButton);

				this.add(submissionPanel, BorderLayout.SOUTH);


				this.setVisible(true);

			}else {
				JOptionPane.showMessageDialog(inputPanel, "Student list is empty.");
			}

		}//End of actionPerformed() method.

	}//End of displayButtonEvent class.


	/**
	 * <p><b>Method Name:</b> updateDisplay()
	 * <p><b>Purpose:</b> To get rid of recursive code that will be used twice.
	 * <p><b>Accepts:</b> Nothing.
	 * <p><b>Returns:</b> Nothing.
	 * <p><b>Date:</b> August 6, 2020
	 */
	void updateDisplay() {

		//Updates the list.
		studentIDOutput.setText(studentList.get(i).getStudentID());
		surnameOutput.setText(studentList.get(i).getSurname());
		middleNameOutput.setText(studentList.get(i).getMiddleName());
		firstNameOutput.setText(studentList.get(i).getFirstName());
		aptNumberOutput.setText(studentList.get(i).getAptNumber());
		streetNumberOutput.setText(studentList.get(i).getStreetNumber());
		streetNameOutput.setText(studentList.get(i).getStreetName());
		cityOutput.setText(studentList.get(i).getCity());
		provinceOutput.setText(studentList.get(i).getProvince());
		postalCodeOutput.setText(studentList.get(i).getPostalCode());
		cslLoanAmountOutput.setText(String.valueOf(studentList.get(i).getCslLoanAmount()));
		oslLoanAmountOutput.setText(String.valueOf(studentList.get(i).getOslLoanAmount()));

		//Default values.
		interestRateTextField.setText("0.00");
		amortizationInput.setText(null);
		cslRequiredLabel.setText("   CSL monthly payment: ");
		oslRequiredLabel.setText("   OSL monthly payment: ");
		totalRequiredLabel.setText("   Total monthly payment: ");
		totalWithInterestLabel.setText("   Total payment with interest: ");
		originalLoanLabel.setText("   Original amount borrowed: ");
		totalInterestPaidLabel.setText("   Total interest paid: ");

	}//End of updateDisplay();


	/**
	 * <p><b>Class Name:</b> previousButtonEvent
	 * <p><b>Purpose:</b> To implement ActionListener for the button to navigate to the previous list in the display frame.
	 * <p><b>Date:</b> August 6, 2020
	 */
	private class previousButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			//Checks if the viewed list is not the first.
			if(i > 0) {
				--i;
				updateDisplay();

			}else {
				JOptionPane.showMessageDialog(displayPanel, "Reached the first student in the list.");
			}

		}//End of actionPerformed() method.

	}//End of previousButtonEvent class.


	/**
	 * <p><b>Class Name:</b> calculateButtonEvent
	 * <p><b>Purpose:</b> To implement ActionListener for the button to begin calculation.
	 * <p><b>Date:</b> August 6, 2020
	 */
	private class calculateButtonEvent implements ActionListener, HA_LoanPayable {

		@Override
		public void actionPerformed(ActionEvent e) {

			if(amortizationInput.getText().isBlank())
				JOptionPane.showMessageDialog(displayPanel, "Please make sure the Amortization period is not blank.");
			else {
				DecimalFormat formatter = new DecimalFormat("$#,##0.00");

				double interestCsl = (Double.parseDouble(interestRateTextField.getText()) + 2.5) * ANNUAL_RATE_TO_MONTHLY_RATE;
				double interestOsl = (Double.parseDouble(interestRateTextField.getText()) + 1.0) * ANNUAL_RATE_TO_MONTHLY_RATE;
				double studentCslLoan = studentList.get(i).getCslLoanAmount();
				double studentOslLoan = studentList.get(i).getOslLoanAmount();
				int amortizationPeriod = Integer.parseInt(amortizationInput.getText());

				//Displays calculated results.
				cslRequiredLabel.setText("   CSL monthly payment: " + formatter.format(calculateLoanPayment(studentCslLoan, interestCsl, amortizationPeriod)));
				oslRequiredLabel.setText("   OSL monthly payment: " + formatter.format(calculateLoanPayment(studentOslLoan, interestOsl, amortizationPeriod)));
				totalRequiredLabel.setText("   Total monthly payment: " + formatter.format(calculateLoanPayment(studentCslLoan, interestCsl, amortizationPeriod)
						+ calculateLoanPayment(studentOslLoan, interestOsl, amortizationPeriod)));
				totalWithInterestLabel.setText("   Total payment with interest: " + formatter.format((calculateLoanPayment(studentCslLoan, interestCsl,
						amortizationPeriod) + calculateLoanPayment(studentOslLoan, interestOsl, amortizationPeriod)) * amortizationPeriod));
				originalLoanLabel.setText("   Original amount borrowed: " + formatter.format(studentCslLoan + studentOslLoan));
				totalInterestPaidLabel.setText("   Total interest paid: " + formatter.format((calculateLoanPayment(studentCslLoan, interestCsl, amortizationPeriod)
						+ calculateLoanPayment(studentOslLoan, interestOsl, amortizationPeriod)) * amortizationPeriod - (studentCslLoan + studentOslLoan)));
			}

		}//End of actionPerformed() method.

		@Override
		public double calculateLoanPayment(double amount, double rate, int amortization) {

			return(amount * rate * Math.pow((1.0 + rate), amortization) / (Math.pow((1 + rate), amortization) - 1.0));

		}//End of calculateLoanPayment() method.

	}//End of editButtonEvent class.


	/**
	 * <p><b>Class Name:</b> nextButtonEvent
	 * <p><b>Purpose:</b> To implement ActionListener for the button to navigate to the next list in the display frame.
	 * <p><b>Date:</b> August 6, 2020
	 */
	private class nextButtonEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			//Checks if the viewed list is not at the end.
			if(studentList.size() > i + 1) {
				++i;
				updateDisplay();
			}else {
				JOptionPane.showMessageDialog(displayPanel, "Reached the last student in the list.");
			}

		}//End of actionPerformed() method.

	}//End of nextButtonEvent class.


	/**
	 * <p><b>Method Name:</b> runValidation()
	 * <p><b>Purpose:</b> Checks if the input in the fields are legal.
	 * <p><b>Accepts:</b> Nothing.
	 * <p><b>Returns:</b> A boolean.
	 * <p><b>Date:</b> August 5, 2020
	 */
	public boolean runValidation() {

		int i = 0;

		if(!studentIDInput.getText().isBlank()) {

			while(i < studentIDInput.getText().length()) {

				if(!Character.isDigit(studentIDInput.getText().charAt(i))) {
					JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure StudentID input contains only numbers.");
					return false;
				}

				++i;
			}//End of while loop.

		}else {
			JOptionPane.showMessageDialog(inputPanel, "Please make sure StudentID is not blank.");
			return false;
		}

		i = 0;

		if(!surnameInput.getText().isBlank()) {

			while(i < surnameInput.getText().length()) {

				if(Character.isDigit(surnameInput.getText().charAt(i))) {
					JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure Surname input contains only letters.");
					return false;
				}

				++i;
			}//End of while loop.

		}else {
			JOptionPane.showMessageDialog(inputPanel, "Please make sure Surname is not blank.");
			return false;
		}

		i = 0;

		while(i < middleNameInput.getText().length()) {

			if(!Character.isAlphabetic(middleNameInput.getText().charAt(i))) {
				JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure Middle name input contains only letters.");
				return false;
			}

			++i;
		}//End of while loop.

		i = 0;

		if(!firstNameInput.getText().isBlank()) {

			while(i < firstNameInput.getText().length()) {

				if(Character.isDigit(firstNameInput.getText().charAt(i))) {
					JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure First name input contains only letters.");
					return false;
				}

				++i;
			}//End of while loop.

		}else {
			JOptionPane.showMessageDialog(inputPanel, "Please make sure First name is not blank.");
			return false;
		}

		i = 0;

		while(i < aptNumberInput.getText().length()) {

			if(!Character.isDigit(aptNumberInput.getText().charAt(i))) {
				JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure Appartment number input contains only numbers.");
				return false;
			}

			++i;
		}//End of while loop.

		i = 0;

		while(i < streetNumberInput.getText().length()) {

			if(!Character.isDigit(streetNumberInput.getText().charAt(i))) {
				JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure Street number input contains only numbers.");
				return false;
			}

			++i;
		}//End of while loop.

		i = 0;

		if(!cslLoanAmountInput.getText().isBlank()) {

			try {
				isNegative(Double.parseDouble(cslLoanAmountInput.getText()));
			}catch(HA_NegativeValueException e) {
				JOptionPane.showMessageDialog(inputPanel, e.toString(), "Illegal Value Used", JOptionPane.OK_OPTION);
				cslLoanAmountInput.setText("" + Math.abs(Double.parseDouble(cslLoanAmountInput.getText())));
			}//End of catch block.

			while(i < cslLoanAmountInput.getText().length()) {

				if(Character.isAlphabetic(cslLoanAmountInput.getText().charAt(i))) {
					JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure CSL loan amount input contains only numbers.");
					return false;
				}

				++i;
			}//End of while loop.

		}else {
			JOptionPane.showMessageDialog(inputPanel, "Please make sure CSL loan amount is not blank.");
			return false;
		}

		i = 0;

		if(!oslLoanAmountInput.getText().isBlank()) {

			try {
				isNegative(Double.parseDouble(oslLoanAmountInput.getText()));
			}catch(HA_NegativeValueException e) {
				JOptionPane.showMessageDialog(inputPanel, e.toString(), "Illegal Value Used", JOptionPane.OK_OPTION);
				oslLoanAmountInput.setText("" + Math.abs(Double.parseDouble(oslLoanAmountInput.getText())));
			}//End of catch block.

			while(i < oslLoanAmountInput.getText().length()) {

				if(Character.isAlphabetic(oslLoanAmountInput.getText().charAt(i))) {
					JOptionPane.showMessageDialog(inputPanel, "Invalid entry, please make sure OSL loan amount input contains only numbers.");
					return false;
				}

				++i;
			}//End of while loop.

		}else {
			JOptionPane.showMessageDialog(inputPanel, "Please make sure OSL loan amount is not blank.");
			return false;
		}

		return true;

	}//End of runValidation() method.


	/**
	 * <p><b>Method Name:</b> isNegative()
	 * <p><b>Purpose:</b> To check if the value passed is a negative number.
	 * <p><b>Accepts:</b> A double.
	 * <p><b>Returns:</b> Nothing.
	 * <p><b>Date:</b> August 4, 2020
	 */
	public void isNegative(double value) throws HA_NegativeValueException {

		//Checks if value received is negative.
		if(value < 0)
			throw new HA_NegativeValueException(value);

	}//End of isNegative() method.


	public static void main(String[] args) {

		new StudentLoanApp();

	}//End of main() method.

}//End of StudentLoanApp class.