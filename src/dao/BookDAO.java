package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.Book;

public class BookDAO extends DAO {

    public BookDAO() {
        super();
    }
    public boolean dele(int a, int b) {
        boolean res = false; // Khởi tạo biến res là false

        String sql = "DELETE FROM returned_book.tblborrowbook WHERE bookid = ? AND bookborrowslipid = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a);
            ps.setInt(2, b);
            int rowsAffected = ps.executeUpdate(); 
            if (rowsAffected > 0) {
                res = true; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean inser(String error, int fineAmount,int bookId) {
        boolean res = false; // Khởi tạo biến res là false

        String sql = "INSERT INTO returned_book.tblpunishedbook (error, fineamount, bookid) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, error);
            ps.setInt(2, fineAmount);
            ps.setInt(3, bookId);
            int rowsAffected = ps.executeUpdate(); 
            if (rowsAffected > 0) {
                res = true; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}