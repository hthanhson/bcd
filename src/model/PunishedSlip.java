package model;

public class PunishedSlip {
    private int id;
    private String error;
    private int fineAmount;
    private int bookReturnSlipId;

    public PunishedSlip(int id, String error, int fineAmount, int bookReturnSlipId) {
        this.id = id;
        this.error = error;
        this.fineAmount = fineAmount;
        this.bookReturnSlipId = bookReturnSlipId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public int getBookReturnSlipId() {
        return bookReturnSlipId;
    }

    public void setBookReturnSlipId(int bookReturnSlipId) {
        this.bookReturnSlipId = bookReturnSlipId;
    }
}
