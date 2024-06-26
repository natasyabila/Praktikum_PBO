package data;

public class BooksBuilder {
    private String idBukuYangDipinjam;
    private Object stock;
    private int duration;

    public void duration() {

    }

    public BooksBuilder setIdBukuYangDipinjam(String idBukuYangDipinjam) {
        this.idBukuYangDipinjam = idBukuYangDipinjam;
        return this;
    }

    public BooksBuilder setStock(Object stock) {
        this.stock = stock;
        return this;
    }

    public BooksBuilder setDuration(Void o) {
        return setDuration(null);
    }

    public BooksBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public Books createBooks() {
        return new Books(idBukuYangDipinjam, stock, duration);
    }
}