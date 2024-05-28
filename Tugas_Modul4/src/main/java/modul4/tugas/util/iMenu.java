package modul4.tugas.util;

import modul4.tugas.books.*;

import java.util.ArrayList;

public interface iMenu {
    void displayMenu();
    void addStudent();
    void inputBook();
    void displayBooks(ArrayList<Book> bookList);
    void displayBorrowedBooks();
    void selectBook();
    void selectStoryBook(ArrayList<StoryBook> bookList);
    void selectBookFromList(ArrayList<Book> bookList);  // New method to avoid clash
}
