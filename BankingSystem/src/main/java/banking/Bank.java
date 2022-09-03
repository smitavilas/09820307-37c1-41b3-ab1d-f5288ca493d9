package banking;
 import  java.lang.Math;
import sun.nio.cs.ext.MacThai;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	private static Long nextCommercialAccNumber = 0L;
	private static Long nextConsumerAccNumber = 0L;


	public Bank() {
		accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long accNum = ++nextConsumerAccNumber;
		CommercialAccount acc = new CommercialAccount(company , accNum ,pin, startingDeposit);
		accounts.put(accNum, acc);
        return accNum;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long accNum = ++nextConsumerAccNumber;
		ConsumerAccount acc = new ConsumerAccount(person , accNum ,pin, startingDeposit);
		accounts.put(accNum, acc);
        return accNum;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		Account account = this.accounts.get(accountNumber);
        return account.validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		Account account = this.accounts.get(accountNumber);
        return account.getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account account = this.accounts.get(accountNumber);
		account.creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		Account account = this.accounts.get(accountNumber);

        return account.debitAccount(amount);
	}
}
