package command;

public class DepositCommand implements Command {

	private int amount;
	private BankAccount account;

	public DepositCommand(int amount, BankAccount account) {
		super();
		this.amount = amount;
		this.account = account;
	}

	public void execute() {
		this.account.balance += amount;
	}

	public void undo() {
		this.account.balance -= amount;
	}

}
