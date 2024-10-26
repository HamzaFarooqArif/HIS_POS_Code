package decorator.table;

//example from: http://www.javaworld.com/javaworld/jw-12-2001/jw-1214-designpatterns.html
import java.awt.*;
import java.awt.event.*;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.table.*;

public class TestLogging extends JFrame {
	public static void main(String args[]) {
		SwingApp.launch(new TestLogging(), "A Sort Decorator", 300, 300, 450, 250);
	}

	public TestLogging() {
		// Create the decorator that will decorate the table's
		// original model. The reference must be final because it's
		// accessed by an inner class below. Notice that the
		// reference is TableSortDecorator even though it
		// actually points to a TableBubbleSortDecorator--that
		// way, the mouse listener below will work with any type
		// of TableSortDecorator.
		final TableSortDecorator decorator = new TableLoggingDecorator(table
				.getModel());

		// Set the table's model to the decorator. Because the
		// decorator implements TableModel, the table will never
		// know the difference between the decorator and it's
		// original model.
		table.setModel(decorator);

		// Add a scroll pane around the table, and add the table
		// the content pane:
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);

		// Add a status area to this frame:
		getContentPane().add(SwingApp.getStatusArea(), BorderLayout.SOUTH);

		SwingApp.showStatus("Nothing Sorted Originally");

		// Obtain a reference to the table's header
		JTableHeader hdr = (JTableHeader) table.getTableHeader();

		// React to mouse clicks in the table header by calling
		// the decorator's sort method.
		hdr.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TableColumnModel tcm = table.getColumnModel();
				int vc = tcm.getColumnIndexAtX(e.getX());
				int mc = table.convertColumnIndexToModel(vc);

				// Perform the sort
				decorator.sort(mc);

				// Update the status area
				SwingApp.showStatus(headers[mc] + " sorted");
			}
		});
	}

	final String[] headers = { "Item", "Price/Lb." };
	JTable table = new JTable(new Object[][] { { "apple", "$.39" },
			{ "mango", "$.49" }, { "papaya", "$1.19" }, { "lemon", "$.19" },
			{ "orange", "$.59" }, { "watermelon", "$.39" },
			{ "tangerine", "$1.09" }, { "cherry", "$.79" },
			{ "banana", "$.29" }, { "lime", "$.33" }, { "grapefruit", "$.69" },
			{ "grapes", "$.49" }, }, headers);

}

