package view.returnbook;

import dao.BookDAO;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import dao.ReturnedBookDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

public class BookFrm extends JFrame {
    private List<BookBorrowSlip> bookBorrowSlips;
    
    private JLabel ifBook;
    private JTextField error,fineAmount;
    
    public BookFrm(List<BookBorrowSlip> bookBorrowSlips,int a,int b) {
        super("Return Book");
        this.bookBorrowSlips = bookBorrowSlips;
        error = new JTextField(15);
        fineAmount = new JTextField(15);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
        JLabel lblTitle = new JLabel("Return Book Information");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
   
        for(BookBorrowSlip x:this.bookBorrowSlips){
            if(x.getId()==b){
                if(x.getBorrowBooks().getBb()!=null){
                    for (Book book : x.getBorrowBooks().getBb()) {
                        if(book.getId()==a){
                            ifBook = new JLabel("<html>ID: " + book.getId() + "<br>Code: " + book.getCode() + "<br>Name: " + book.getName()+ "<br>Author: " + book.getAuthor()+ "<br>Price: " + book.getPrice()+ "<br>Status: " + book.getStatus()+ "<br>Describe: " + book.getDes() +"</html>");
                        }
                    }
                }
            }
        }
        
        ifBook.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(lblTitle);
        topPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        topPanel.add(ifBook);
        
        JPanel pnError = new JPanel();
	pnError.setLayout(new FlowLayout(FlowLayout.LEFT));
	pnError.add(new JLabel("Error:"));
	pnError.add(error);
	topPanel.add(pnError);
        
        JPanel pnFineAmount = new JPanel();
	pnFineAmount.setLayout(new FlowLayout(FlowLayout.LEFT));
	pnFineAmount.add(new JLabel("FineAmount:"));
	pnFineAmount.add(fineAmount);
	topPanel.add(pnFineAmount);
        
        topPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        JButton btnReturn = new JButton("Return Book");
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDAO bookDAO = new BookDAO();
                boolean dele = bookDAO.dele(a, b);
                String errorValue = error.getText().trim();
                String fineAmountValue = fineAmount.getText().trim();
                if(!errorValue.isEmpty() && !fineAmountValue.isEmpty()){ 
                    int fAValue = Integer.parseInt(fineAmountValue);
                    boolean inser =bookDAO.inser(errorValue,fAValue,a);
                }
 
                JOptionPane.showMessageDialog(BookFrm.this, "Book returned successfully!");
                dispose();
            }
        });
        bottomPanel.add(btnReturn);
        add(bottomPanel, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        setVisible(true);
        
    }
}
