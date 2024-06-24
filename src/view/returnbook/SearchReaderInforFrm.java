package view.returnbook;
import java.util.List;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Client;
import dao.ClientDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Book;
import model.User;

public class SearchReaderInforFrm extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JLabel lblName;
    private JTextField txtName;
    private JButton btnSearch;
    private JPanel mainPanel;
    private ClientDAO clientDAO;
    private User user;

    public SearchReaderInforFrm(User user) {
        super("Search Reader Information");
        clientDAO = new ClientDAO();
        this.user=user;

        lblTitle = new JLabel("Search Reader Information");
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lblName = new JLabel("Name:");
        txtName = new JTextField(20);
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel.add(lblName);
        namePanel.add(txtName);
        namePanel.add(btnSearch);


        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(lblTitle);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(namePanel);

        this.add(mainPanel, BorderLayout.CENTER);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnSearch) {
        String name = txtName.getText().trim();
        if (!name.isEmpty()) {
            List<Client> clients = clientDAO.searchClientsByName(name);
            if (clients.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No clients found with the name: " + name);
            } else {
                JComboBox<String> readerComboBox = new JComboBox<>();
                for (Client client : clients) {
                    readerComboBox.addItem(client.getName());
                }

                int option = JOptionPane.showConfirmDialog(null, readerComboBox, "Select a reader", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    int selectedIndex = readerComboBox.getSelectedIndex();
                    if (selectedIndex != -1) {
                        Client selectedClient = clients.get(selectedIndex);
                        ReturnBookFrm returnBookFrm = new ReturnBookFrm(selectedClient,user);
                        returnBookFrm.setVisible(true);
                        this.dispose();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a name to search.");
        }
    }
}

//    public static void main(String[] args) {
//        // Tạo và hiển thị giao diện SearchReaderInforFrm
//        SearchReaderInforFrm frm = new SearchReaderInforFrm(user);
//        frm.setVisible(true);
//    }
}