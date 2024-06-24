package view.returnbook;

import dao.BookDAO;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import model.Book;
import model.Client;
import dao.ReturnedBookDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import model.*;

public class ReturnBookFrm extends JFrame {
    private Client client;
    private ReturnedBookDAO returnedBookDAO;
    private JTable table;
    private User user;
    private JLabel lblClient;
    private BorrowBook borrowBook;
    private List<BookBorrowSlip> bookborrowslips;

    public ReturnBookFrm(Client client, User user) {
        super("Return Book Information");
        this.client = client;
        this.user = user;
        returnedBookDAO = new ReturnedBookDAO();
        BookDAO bookDAO = new BookDAO();
        initializeUI();
        loadBorrowedBooks();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
        JLabel lblTitle = new JLabel("Return Book Information");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblClient = new JLabel("<html>Client: " + client.getName() + "<br>Code: " + client.getCode() + "<br>Depositamount: " + client.getDepositamount() +"</html>");
        lblClient.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(lblTitle);
        topPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        topPanel.add(lblClient);
        topPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        add(topPanel, BorderLayout.NORTH);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton btnReturn = new JButton("Return Book");
        btnReturn.addActionListener(e -> returnBook());
        bottomPanel.add(btnReturn);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void loadBorrowedBooks() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "Code", "Name", "Author", "Price", "Status", "Description","borrowday","returnday","note","IdSlip"}, 0);
        
        List<BookBorrowSlip> bbs=returnedBookDAO.getBookBorrowSlip(client,user);
        for(int i = 0; i < bbs.size(); i++){
            BorrowBook bookb=returnedBookDAO.getBorrowedBook(bbs.get(i).getId());
            if (bookb != null){
                bbs.get(i).setBorrowBooks(bookb);
            }
        }
        this.bookborrowslips=bbs;
        for(BookBorrowSlip x:bbs){
            if(x.getBorrowBooks().getBb()!=null){
                for (Book book : x.getBorrowBooks().getBb()) {
                model.addRow(new Object[]{
                    book.getId(), book.getCode(), book.getName(), book.getAuthor(),
                    book.getPrice(), book.getStatus(), book.getDes(),x.getBorrowDay(),x.getReturnDay(),x.getNote(),x.getId()
                });
            }
            }
        }
        table.setModel(model);
    }

    private void returnBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Object objValue1=table.getValueAt(selectedRow, 0);
            Object objValue2=table.getValueAt(selectedRow, 10);
            Integer a = (Integer) objValue1;
            Integer b = (Integer) objValue2;
            BookFrm bookFrm = new BookFrm(this.bookborrowslips,a,b);
            bookFrm.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBorrowedBooks();
                }
            });
            bookFrm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(ReturnBookFrm.this, "Please select a book to return.");
        }
    }
}
