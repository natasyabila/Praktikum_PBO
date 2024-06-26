package data;

public class Books {
    private String idBukuYangDipinjam;
    private int  stock;
    private int duration;
    private String title;
    private String author;
    private String category;
    public static Books[] arr_bookList;
    public static Books[] arr_borrowedBook; // Changed to array of Books

    // Konstruktor
    public Books(String idBukuYangDipinjam, Object stock, int duration) {
        this.idBukuYangDipinjam = idBukuYangDipinjam;
        this.stock = (int) stock;
        this.duration = duration;
    }

    // Getter dan Setter
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Object getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = (int) stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookId() {
        return idBukuYangDipinjam;
    }

    public void setBookId(String idBukuYangDipinjam) {
        this.idBukuYangDipinjam = idBukuYangDipinjam;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
