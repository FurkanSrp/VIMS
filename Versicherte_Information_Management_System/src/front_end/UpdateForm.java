package front_end;

import javax.swing.*;

import p1.UpdateData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateForm extends JFrame {
    public UpdateForm() {
        setTitle("Daten Aktualisieren");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(20, 20, 100, 25);
        add(labelId);

        JTextField fieldId = new JTextField();
        fieldId.setBounds(150, 20, 200, 25);
        add(fieldId);

        JLabel labelFirstName = new JLabel("Neue Vorname:");
        labelFirstName.setBounds(20, 60, 100, 25);
        add(labelFirstName);

        JTextField fieldFirstName = new JTextField();
        fieldFirstName.setBounds(150, 60, 200, 25);
        add(fieldFirstName);

        JLabel labelLastName = new JLabel("Neue Nachname:");
        labelLastName.setBounds(20, 100, 100, 25);
        add(labelLastName);

        JTextField fieldLastName = new JTextField();
        fieldLastName.setBounds(150, 100, 200, 25);
        add(fieldLastName);

        JLabel labelBirthDate = new JLabel("Neue Geburtsdatum:");
        labelBirthDate.setBounds(20, 140, 120, 25);
        add(labelBirthDate);

        JTextField fieldBirthDate = new JTextField();
        fieldBirthDate.setBounds(150, 140, 200, 25);
        add(fieldBirthDate);

        JLabel labelInsuranceNumber = new JLabel("Neue Versicherte Nr:");
        labelInsuranceNumber.setBounds(20, 180, 120, 25);
        add(labelInsuranceNumber);

        JTextField fieldInsuranceNumber = new JTextField();
        fieldInsuranceNumber.setBounds(150, 180, 200, 25);
        add(fieldInsuranceNumber);

        JButton buttonUpdate = new JButton("Aktualisieren");
        buttonUpdate.setBounds(150, 220, 100, 30);
        add(buttonUpdate);

        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(fieldId.getText());
                String firstName = fieldFirstName.getText();
                String lastName = fieldLastName.getText();
                String birthDate = fieldBirthDate.getText();
                String insuranceNumber = fieldInsuranceNumber.getText();

                UpdateData.updatePersonData(id, firstName, lastName, birthDate, insuranceNumber);
            }
        });

        setLocationRelativeTo(null);
    }
}

