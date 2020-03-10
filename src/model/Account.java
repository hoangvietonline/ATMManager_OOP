package model;

public class Account {
	private String accountNo;
	private String ownerName;
	private double amount;
	private String accountType;

	public Account() {
		super();
	}

	public Account(String accountNo, String ownerName, double amount, String accountType) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.amount = amount;
		this.accountType = accountType;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void deposit(double amount) {
		this.setAmount(this.amount + amount);
		System.out.println("The balance in account " + getOwnerName() + " is : " + getAmount() + " " + "VND");
	}

	public boolean withdraw(double amount) {
		if (amount < this.amount) {
			this.setAmount(this.amount - amount);
			System.out.println("The balance in account " + getOwnerName() + " is : " + getAmount() + " " + "VND");
			return true;
		} else {
			System.out.println("Balance in your account is not enough to make a transaction");
			return false;
		}
	}
}
