package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Account;

public class AccoutUtils {

	public static List<Account> mAccounts = new ArrayList<>();

	public AccoutUtils() {
		addAccount();
	}

	public void withDraw(Account account, Scanner sc) {
		System.out.println("Enter the amout you want to withdraw");
		double amoutWithdraw = sc.nextDouble();
		account.withdraw(amoutWithdraw);
	}

	public void deposit(Account account, Scanner sc) {
		System.out.println("Enter the amout you want to deposit");
		double amoutDeposit = sc.nextDouble();
		account.deposit(amoutDeposit);
	}

	public void viewAmount(Account account) {
		System.out.println("The balance in your account is : " + account.getAmount() + " " + "VND");
	}

	public void infoAccount(Account account) {
		System.out.println("Information Account");
		System.out.println("AccountNo : " + account.getAccountNo());
		System.out.println("OwnerName : " + account.getOwnerName());
		System.out.println("Amount : " + account.getAmount());
		System.out.println("AccountType : " + account.getAccountType());
	}

	public void transferMoney(Account mAccount, Scanner sc) {
		System.out.println("Enter the accountNo you want to transfer money");
		String accountNo = sc.next();
		Account guestAccount = findAccountByAcountNo(accountNo);
		if (guestAccount != null) {
			System.out.println("Enter the amount you want to transfer to the account : " + guestAccount.getOwnerName());
			sc.nextLine();
			double money = sc.nextInt();
			boolean b = mAccount.withdraw(money);
			if (b) {
				guestAccount.deposit(money);
			}
		} else if (accountNo.equalsIgnoreCase(mAccount.getAccountNo())) {
			System.out.println("This is your account!");
		} else {
			System.out.println("AcountNo no exsit!");
		}
	}

	public void getMenu(Account account) {
		System.out.println("==========================");
		System.out.println("Hello " + account.getOwnerName());
		System.out.println("Please choose (1 - 5)");
		System.out.println("1.withdraw");
		System.out.println("2.deposit");
		System.out.println("3.viewAmout");
		System.out.println("4.transfer money");
		System.out.println("5.Exit");
		System.out.println("---------------------------");
	}

	public void signIn() {
		System.out.println("==SIGN IN==");
		System.out.println("1. Enter accountNo");
		System.out.println("2 .Exit");
	}

	public Account findAccountByAcountNo(String accountNo) {
		Account account = null;
		for (Account ac : mAccounts) {
			if (accountNo.equalsIgnoreCase(ac.getAccountNo())) {
				account = ac;
				return account;
			}
		}
		return null;
	}

	public void addAccount() {
		Account account1 = new Account("AC12345", "Hoang Viet", 200000, "Saving account");
		Account account2 = new Account("BK91186", "Dat G", 300000, "Saving account");
		AccoutUtils.mAccounts.add(account1);
		AccoutUtils.mAccounts.add(account2);
	}
}
