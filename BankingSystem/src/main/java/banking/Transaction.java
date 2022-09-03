package banking;

/**
 *
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction {
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank
	 *            The bank where the account is housed.
	 * @param accountNumber
	 *            The customer's account number.
	 * @param attemptedPin
	 *            The PIN entered by the customer.
	 * @throws Exception
	 *             Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		this.bank = bank;
		this.accountNumber = accountNumber;
		Account acc = bank.getAccount(accountNumber);
		if (!acc.validatePin(attemptedPin)) {
			throw new Exception();
		}
	}

	public double getBalance() {
		Account acc = bank.getAccount(accountNumber);
 return acc.getBalance();
	}

	public void credit(double amount) {
		Account acc = bank.getAccount(accountNumber);
		acc.creditAccount(amount);
	}

	public boolean debit(double amount) {
		Account acc = bank.getAccount(accountNumber);
        return acc.debitAccount(amount);
	}
}
