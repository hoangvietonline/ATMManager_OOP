package model;

import java.util.InputMismatchException;
import java.util.Scanner;

import common.AccoutUtils;

public class ATM {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		AccoutUtils ui = new AccoutUtils();
		boolean checkSingIn = true;
		boolean checkExitAccout = true;

		while (checkSingIn) {
			checkExitAccout = true;
			ui.signIn();
			try {
				int chooseSignIn = sc.nextInt();
				switch (chooseSignIn) {
				case 1:
					System.out.println("Enter the accountNo your account");
					String accoutNo = sc.next();
					Account account = ui.findAccountByAcountNo(accoutNo);
					if (account != null) {
						while (checkExitAccout) {
							ui.getMenu(account);
							try {
								int choose = sc.nextInt();
								switch (choose) {
								case 1:
									ui.withDraw(account, sc);
									break;
								case 2:
									ui.deposit(account, sc);
									break;
								case 3:
									ui.viewAmount(account);
									break;
								case 4:
									ui.transferMoney(account, sc);
									break;
								case 5:
									checkExitAccout = false;
									break;
								}
							}catch(InputMismatchException e) {
								System.out.println("Please enter number(1 -5)!");
								sc.nextLine();
							}
						}
					} else {
						System.out.println("AcountNo no exsit,Please enter again!");
					}
					break;
				default:
					checkSingIn = false;
					System.out.println("Bye, see you again!");
					sc.nextLine();
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter number(1 -2)!");
				sc.nextLine();
			}
		}
	}
}
