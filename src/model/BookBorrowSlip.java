package model;

import java.util.Date;
import java.util.List;

public class BookBorrowSlip {
    private int id;
    private String code;
    private Date borrowDay;
    private Date returnDay;
    private String note;
    private Client client;
    private User user;
    private BorrowBook borrowBooks;
    public BookBorrowSlip(){}
    public BookBorrowSlip(int id, Date borrowDay,Date returnDay, String note, Client client, User user, BorrowBook borrowBooks) {
        this.id = id;
        this.borrowDay = borrowDay;
        this.returnDay=returnDay;
        this.note = note;
        this.client = client;
        this.user = user;
        this.borrowBooks = borrowBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public Date getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }
    public Date getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(Date borrowDay) {
        this.borrowDay = borrowDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BorrowBook getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(BorrowBook borrowBooks) {
        this.borrowBooks = borrowBooks;
    }
}
