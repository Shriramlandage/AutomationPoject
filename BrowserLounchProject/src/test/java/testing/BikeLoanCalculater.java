package testing;

import java.util.Scanner;

public class BikeLoanCalculater {

	public static void main(String[] args) {
		// Bike details
		double bikePrice = 91995;
		double downPayment = 30000;
		double annualInterestRate = 8;
		int loanTenureMonths = 18;
		

		// Calculate loan amount
		double loanAmount = bikePrice - downPayment;
		System.out.println("My Loan Amount is :" + loanAmount);

		// Calculate monthly interest rate
		double monthlyInterestRate = (annualInterestRate / 12) / 100;

		// Calculate number of monthly installments
		int numberOfInstallments = loanTenureMonths;

		// Calculate EMI using the formula
		double emi = calculateEMI(loanAmount, monthlyInterestRate, numberOfInstallments);

		// Print the EMI
		System.out.println("Monthly EMI: Rs" + emi);

		double intrestamount = emi * loanTenureMonths;
		System.out.println("Loan Tenure into EMI ammout:"+intrestamount);
		
		double IntrestRs= intrestamount-loanAmount;
		System.out.println(IntrestRs);
		
		double finalprice=intrestamount +downPayment -bikePrice;
		System.out.println("Net Extra cost:"+finalprice);

		
	}

	private static double calculateEMI(double loanAmount, double monthlyInterestRate, int numberOfInstallments) {
		double numerator = loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfInstallments);
		double denominator = Math.pow(1 + monthlyInterestRate, numberOfInstallments) - 1;
		return numerator / denominator;
	}
}
