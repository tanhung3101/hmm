package nop.view.ui;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import nop.controller.Controller;
import nop.dto.Bill;
import nop.model.Model;

public class TemplateBillReportView extends JPanel {

	JLabel lblHeader = new JLabel("List Word");
	JTable tableView = new JTable();
	Controller controller;
	JScrollPane tableContainer;
	TableModel tableModel = new DefaultTableModel();
	String[] columnNames = { "No.", "Name" };

	public TemplateBillReportView(Controller controller) {
		try {
			this.controller = controller;
			loadTable();
			jbInit();
			regisetListner();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void loadTable() {
		tableModel = new DefaultTableModel(getDataObject(controller.getModel()
				.getLstTemplateBills()), columnNames);
		tableView = new JTable(tableModel) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableContainer = new JScrollPane(tableView);

	}

	public Object[][] getDataObject(ArrayList lstAllWords) {
		Object[][] data = new Object[lstAllWords.size()][2];

		for (int i = 0; i < lstAllWords.size(); i++) {
			Bill dto = (Bill) lstAllWords.get(i);
			data[i][0] = i;
			data[i][1] = String.valueOf(dto.getName());
			// data[i][2] = String.valueOf(dto.getMonth());
			// data[i][3] = String.valueOf(dto.getAmountMoney());
			// data[i][4] = String.valueOf(dto.getPayerID());
		}

		return data;

	}

	private void jbInit() {
		// TODO Auto-generated method stub
		this.setLayout(null);

		lblHeader.setBounds(new Rectangle(0, 0, 100, 20));
		tableContainer.setBounds(new Rectangle(30, 30, 500, 300));

		this.add(lblHeader);
		this.add(tableContainer);
		this.setSize(300, 300);
	}

	public void refreshTable() {
		tableModel = new DefaultTableModel(getDataObject(controller.getModel()
				.getLstTemplateBills()), columnNames);
		tableView.setModel(tableModel);
		tableContainer.setViewportView(tableView);
	}

	public void regisetListner() {
		tableView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					EditTemplateBillView view=new EditTemplateBillView(controller, new Bill());
					view.show(true);
					view.setSize(200, 200);
				}
				System.out.println("a:"
						+ tableView.getValueAt(tableView.getSelectedRow(), 0));
			}
		});
	}
}
