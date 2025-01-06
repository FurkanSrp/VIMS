package front_end;

import javax.swing.*;

import p1.DeleteData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteForm extends JFrame {
    public DeleteForm() {
        setTitle("Daten Löschen");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(20, 20, 100, 25);
        add(labelId);

        JTextField fieldId = new JTextField();
        fieldId.setBounds(100, 20, 150, 25);
        add(fieldId);

        JButton buttonDelete = new JButton("Sil");
        buttonDelete.setBounds(100, 60, 100, 30);
        add(buttonDelete);

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(fieldId.getText());
                DeleteData.deletePerson(id);
            }
        });

        setLocationRelativeTo(null);
    }
}

