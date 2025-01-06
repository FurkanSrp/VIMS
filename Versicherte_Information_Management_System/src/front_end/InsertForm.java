package front_end;

import javax.swing.*;
import p1.InsertData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertForm extends JFrame {
	public InsertForm() {
		setTitle("Neue Daten Einfügen");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		JLabel labelFirstName = new JLabel("Vorname:");
		labelFirstName.setBounds(20, 20, 100, 25);
		add(labelFirstName);

		JTextField fieldFirstName = new JTextField();
		fieldFirstName.setBounds(150, 20, 200, 25);
		add(fieldFirstName);

		JLabel labelLastName = new JLabel("Nachname:");
		labelLastName.setBounds(20, 60, 100, 25);
		add(labelLastName);

		JTextField fieldLastName = new JTextField();
		fieldLastName.setBounds(150, 60, 200, 25);
		add(fieldLastName);

		JLabel labelBirthDate = new JLabel("Geburtsdatum:");
		labelBirthDate.setBounds(20, 100, 100, 25);
		add(labelBirthDate);

		JTextField fieldBirthDate = new JTextField();
		fieldBirthDate.setBounds(150, 100, 200, 25);
		add(fieldBirthDate);

		JLabel labelInsuranceNumber = new JLabel("Versicherte Nr:");
		labelInsuranceNumber.setBounds(20, 140, 100, 25);
		add(labelInsuranceNumber);

		JTextField fieldInsuranceNumber = new JTextField();
		fieldInsuranceNumber.setBounds(150, 140, 200, 25);
		add(fieldInsuranceNumber);

		JButton buttonSave = new JButton("Speichern");
		buttonSave.setBounds(150, 200, 100, 30);
		add(buttonSave);

		buttonSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String firstName = fieldFirstName.getText();
				String lastName = fieldLastName.getText();
				String birthDate = fieldBirthDate.getText();
				String insuranceNumber = fieldInsuranceNumber.getText();

				// Doğum tarihi doğrulama
				if (!isValidDate(birthDate)) {
					JOptionPane.showMessageDialog(null, "Bitte geben Sie eie gültige Geburtsdatum! (YYYY-MM-DD)");
					return; // Eğer tarih yanlışsa, işlemi durdur
				}

				// Eğer doğrulama başarılıysa veriyi kaydet
				InsertData.insertData(firstName, lastName, birthDate, insuranceNumber);
			}
		});

		setLocationRelativeTo(null);
	}

	// Tarih doğrulama metodu
	private boolean isValidDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
}
