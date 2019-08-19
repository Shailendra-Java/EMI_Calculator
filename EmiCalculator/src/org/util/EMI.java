package org.util;

public class EMI {
	private double intererstRate;
	private double amount;
	private String month;

	public EMI(double intererstRate, double amount, String month) {
		super();
		this.intererstRate = intererstRate;
		this.amount = amount;
		this.month = month;
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
