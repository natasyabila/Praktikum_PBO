package modul4.tugas.data;

import modul4.tugas.books.Book;

import java.util.ArrayList;

public abstract class User {



    private final String nim;

    public User(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void displayBooks(ArrayList<Book> bookList){

    }

    public void addStudent(){

    }

    public void inputBook(){

    }

    public void choiceBook(ArrayList<Book> bookList){

    }
}