package model;

import java.util.List;

public class BorrowBook {
    private int id;
    private List<Book> bb;
    private int bbsid;
    public BorrowBook(){}
    public BorrowBook(int id, List<Book> bb, int bbsid) {
        this.id = id;
        this.bb = bb;
        this.bbsid = bbsid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBb() {
        return bb;
    }

    public void setBb(List<Book> bb) {
        this.bb = bb;
    }

    public int getBbsid() {
        return bbsid;
    }

    public void setBbsid(int bbsid) {
        this.bbsid = bbsid;
    }
}