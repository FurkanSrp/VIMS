package front_end;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Versicherte Information Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Ekleme butonu
        JButton addButton = new JButton("Einfügen");
        addButton.setBounds(50, 50, 120, 30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertForm insertForm = new InsertForm();
                insertForm.setVisible(true);
            }
        });

        // Listeleme butonu
        JButton listButton = new JButton("Listen");
        listButton.setBounds(200, 50, 120, 30);
        add(listButton);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListForm listForm = new ListForm();
                listForm.setVisible(true);
            }
        });

        // Güncelleme butonu
        JButton updateButton = new JButton("Aktualisieren");
        updateButton.setBounds(50, 100, 120, 30);
        add(updateButton);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateForm updateForm = new UpdateForm();
                updateForm.setVisible(true);
            }
        });

        // Silme butonu
        JButton deleteButton = new JButton("Löschen");
        deleteButton.setBounds(200, 100, 120, 30);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteForm deleteForm = new DeleteForm();
                deleteForm.setVisible(true);
            }
        });

        setLocationRelativeTo(null); // Ortala
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
        });
    }
}
