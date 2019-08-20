package org.util;

public class EMI {
	private double intererstRate;
	private double amount;
	private String month;
	private double totalInterest;
	private double totalAmount;
	private int noOfMonths;
	private double emi;
	private double interestPerMonth;
	private double principalPerMonth;
	private double balancePrincipal;

	public EMI(String month, double emi, double interestPerMonth, double principalPerMonth, double balancePrincipal) {
		super();
		this.month = month;
		this.emi = emi;
		this.interestPerMonth = interestPerMonth;
		this.principalPerMonth = principalPerMonth;
		this.balancePrincipal = balancePrincipal;
	}

	public EMI(double intererstRate, double amount, double totalInterest, double totalAmount, int noOfMonths) {
		super();
		this.intererstRate = intererstRate;
		this.amount = amount;
		this.totalInterest = totalInterest;
		this.totalAmount = totalAmount;
		this.noOfMonths = noOfMonths;
	}

	public double getTotalInterest() {
		return totalInterest;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public int getNoOfMonths() {
		return noOfMonths;
	}

	public double getEmi() {
		return emi;
	}

	public double getInterestPerMonth() {
		return interestPerMonth;
	}

	public double getPrincipalPerMonth() {
		return principalPerMonth;
	}

	public double getBalancePrincipal() {
		return balancePrincipal;
	}

	public String getMonth() {
		return month;
	}

	public double getIntererstRate() {
		return intererstRate;
	}

	public double getAmount() {
		return amount;
	}

}
