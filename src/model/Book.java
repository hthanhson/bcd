package model;

public class Book {
    private int id;
    private String code;
    private String name;
    private String author;
    private int price;
    private String status;
    private String des;

    public Book() {
      
    }

    public Book(int id, String code, String name, String author, int price, String status, String des) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.author = author;
        this.price = price;
        this.status = status;
        this.des = des;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
