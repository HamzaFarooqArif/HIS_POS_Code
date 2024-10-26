package command;

public class Test {
	public static void main(String[] args) {
		BankAccount account = new BankAccount(100000);
		Command command1 = new DepositCommand(10000, account);
		Command command2 = new DepositCommand(20000, account);
		Command command3 = new DepositCommand(30000, account);
		
		command1.execute();
		command2.execute();
		command3.execute();
		
		System.out.println(account.balance);
		command2.undo();
		System.out.println(account.balance);
		
		Command command4 = new WithDrawalCommand(60000, account);
		command4.execute();
		System.out.println(account.balance);
		command4.undo();
		System.out.println(account.balance);
		
		
		// what to avoid multiple execution? Ad TX-IDs?! where to put responsibility for maintaining integrity?
		// distributed commands, GUIDs 
		// add macro command -> JDBC!!!
		
	}
}
