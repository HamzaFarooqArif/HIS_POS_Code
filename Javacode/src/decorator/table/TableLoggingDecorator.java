package decorator.table;

import javax.swing.table.TableModel;

public class TableLoggingDecorator extends TableBubbleSortDecorator{

	public TableLoggingDecorator(TableModel model) {
		super(model);

	}
	
	public void sort(int column){
		System.out.println("Start sorting column: " + column);
		super.sort(column);
		System.out.println("Finished sorting column: " + column);
	}
	
}
