package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.BookBorrowSlip;
import model.BorrowBook;
import model.Client;
import model.User;

public class ReturnedBookDAO extends DAO {

    public ReturnedBookDAO() {
        super();
    }

    public BorrowBook getBorrowedBook(int id1) {     
            BorrowBook borrowedBook = new BorrowBook();
            List<Book> books = new ArrayList<>();
            String sql = "SELECT b.*" +
    "FROM returned_book.tblclient c\n" +
    "INNER JOIN returned_book.tblbookborrowslip bs ON c.id = bs.clientid\n" +
    "INNER JOIN returned_book.tblborrowbook bb ON bs.id = bb.bookborrowslipid\n" +
    "INNER JOIN returned_book.tblbook b ON bb.bookid = b.id\n" +
    "WHERE bs.id=?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id1);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String code = rs.getString("code");
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    int price = rs.getInt("price");
                    String status = rs.getString("status");
                    String des = rs.getString("des");

                    Book book = new Book(id, code, name, author, price, status, des);
                    books.add(book);
                    borrowedBook.setBb(books);                        
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        return borrowedBook;
    }
    public List<BookBorrowSlip> getBookBorrowSlip(Client c,User u) {
            List<BookBorrowSlip> bookBorrowSlips = new ArrayList<>();
            String sql = "SELECT * FROM returned_book.tblbookborrowslip WHERE clientid=?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
                    BookBorrowSlip bookBorrowSlip = new BookBorrowSlip();
                        bookBorrowSlip.setId(rs.getInt("id"));
                        bookBorrowSlip.setCode(rs.getString("code"));
                        bookBorrowSlip.setBorrowDay(rs.getDate("borrowday"));
                        bookBorrowSlip.setReturnDay(rs.getDate("returnday"));
                        bookBorrowSlip.setNote(rs.getString("note"));
                        bookBorrowSlip.setClient(c);
                        bookBorrowSlip.setUser(u);
                        bookBorrowSlips.add(bookBorrowSlip);
		}
            } catch (Exception e) {
		e.printStackTrace();
            }
            return bookBorrowSlips;
    }
}
