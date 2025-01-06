package front_end;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import p1.RetrieveData;

import java.util.List;

public class ListForm extends JFrame {

	public ListForm() {
		setTitle("Daten Listen");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		// Tablo modeli
		String[] columns = { "ID", "Vorname", "Nachname", "Geburtsdatum", "Versicherte Nr" };
		DefaultTableModel model = new DefaultTableModel(columns, 0);

		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 20, 550, 300);
		add(scrollPane);

		// Veritabanından verileri al ve tabloya ekle
		List<Object[]> persons = RetrieveData.retrieveAllPersons();
		for (Object[] person : persons) {
			model.addRow(person);
		}

		setLocationRelativeTo(null); // Ortala
	}
}
