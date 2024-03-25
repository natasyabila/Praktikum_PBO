package org.example;
import java.util.Scanner;

public class Main {
    private static String[][] Book;
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id buku: ");
        String id = scanner.nextLine();
        System.out.println("Enter stok: ");
        String stok = scanner.nextLine();
        System.out.println("Enter Author: ");
        String Author = scanner.nextLine();
        System.out.println("Enter Pengarang: ");
        String Pengarang = scanner.nextLine();
        System.out.println("Enter Judul: ");
        String Judul = scanner.nextLine();

        // Lakukan pengecekan untuk menghindari NullPointerException
        if (Book == null) {
            Book = new String[10][5];
        }

        for (int i = 0; i < Book.length; i++) {
            if (Book[i][0] == null) {
                Book[i] = new String[]{id, stok, Author, Pengarang, Judul};
                System.out.println("Book added successfully.");
                return;
            }
        }
        System.out.println("Failed to add book. Book database full.");
    }

    private static final String[][] userStudent = new String[10][4]; // Assuming max 10 users

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Library System");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    Student student = new Student();
                    student.menuStudent();
                    break;
                case 2:
                    System.out.println("Admin Login");
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                        Admin admin = new Admin();
                        admin.menuAdmin();
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 3:
                    System.out.println("Thank you. Exiting program.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 3);
        scanner.close();
    }

    static class Student {
        Scanner scanner = new Scanner(System.in);

        public static void displayBooks() {
            System.out.println("List of Books:");
            if (Book == null) {
                System.out.println("No books available.");
                return;
            }
            System.out.println("ID || Stock || Author || Pengarang || Judul");
            for (String[] book : Book) {
                if (book[0] != null) {
                    System.out.println(book[0] + " || " + book[1] + " || " + book[2] + " || " + book[3] + " || " + book[4]);
                }
            }
        }
        public static void borrowBook() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the book you want to borrow: ");
            String id = scanner.nextLine();
            boolean found = false;
            for (int i = 0; i < Book.length; i++) {
                if (Book[i] != null && Book[i][0].equals(id)) {
                    found = true;
                    int stock = Integer.parseInt(Book[i][1]);
                    if (stock > 0) {
                        stock--;
                        Book[i][1] = String.valueOf(stock);
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Sorry, the book is out of stock.");
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not found.");
            }
        }

        public static void returnBook() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the book you want to return: ");
            String id = scanner.nextLine();
            boolean found = false;
            for (int i = 0; i < Book.length; i++) {
                if (Book[i] != null && Book[i][0].equals(id)) {
                    found = true;
                    int stock = Integer.parseInt(Book[i][1]);
                    stock++;
                    Book[i][1] = String.valueOf(stock);
                    System.out.println("Book returned successfully.");
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not found.");
            }
        }


        void menuStudent() {
            int option;
            do {
                System.out.println("Student Dashboard");
                System.out.println("1. Display Available Books");
                System.out.println("2. Borrow Book");
                System.out.println("3. Return Book");
                System.out.println("4. Logout");
                System.out.print("Choose option (1-4): ");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        displayBooks();
                        break;
                    case 2:
                        System.out.println("Borrow Book feature is not implemented yet.");
                        break;
                    case 3:
                        System.out.println("Return Book feature is not implemented yet.");
                        break;
                    case 4:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } while (option != 4);
        }
    }

    static class Admin {
        Scanner scanner = new Scanner(System.in);

        void addStudent() {
            System.out.println("Enter student name: ");
            String name = scanner.nextLine();
            System.out.println("Enter student NIM: ");
            String nim;
            do {
                nim = scanner.nextLine();
                if (nim.length() != 15)
                    System.out.println("NIM must be 15 digits long. Please enter again: ");
            } while (nim.length() != 15);
            System.out.println("Enter student faculty: ");
            String faculty = scanner.nextLine();
            System.out.println("Enter student program: ");
            String program = scanner.nextLine();
            for (int i = 0; i < userStudent.length; i++) {
                if (userStudent[i][0] == null) {
                    userStudent[i] = new String[]{name, nim, faculty, program};
                    System.out.println("Student successfully registered.");
                    return;
                }
            }
            System.out.println("Failed to add student. Student database full.");
        }

        void displayStudents() {
            System.out.println("List of Registered Students:");
            System.out.println("Name || Faculty || NIM || Program");
            for (String[] student : userStudent) {
                if (student[0] != null) {
                    System.out.println(student[0] + " || " + student[2] + " || " + student[1] + " || " + student[3]);
                }
            }
        }
        public static void borrowBook() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the book you want to borrow: ");
            String id = scanner.nextLine();
            boolean found = false;
            for (int i = 0; i < Book.length; i++) {
                if (Book[i] != null && Book[i][0].equals(id)) {
                    found = true;
                    int stock = Integer.parseInt(Book[i][1]);
                    if (stock > 0) {
                        stock--;
                        Book[i][1] = String.valueOf(stock);
                        System.out.println("Book borrowed successfully.");
                        return; // keluar dari fungsi setelah buku berhasil dipinjam
                    } else {
                        System.out.println("Sorry, the book is out of stock.");
                        return; // keluar dari fungsi jika buku kehabisan stok
                    }
                }
            }
            // Cetak pesan jika buku tidak ditemukan setelah loop selesai
            System.out.println("Book not found.");
        }

        public static void returnBook() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the book you want to return: ");
            String id = scanner.nextLine();
            boolean found = false;
            for (int i = 0; i < Book.length; i++) {
                if (Book[i] != null && Book[i][0].equals(id)) {
                    found = true;
                    int stock = Integer.parseInt(Book[i][1]);
                    stock++;
                    Book[i][1] = String.valueOf(stock);
                    System.out.println("Book returned successfully.");
                    return; // keluar dari fungsi setelah buku berhasil dikembalikan
                }
            }
            // Cetak pesan jika buku tidak ditemukan setelah loop selesai
            System.out.println("Book not found.");
        }


        void menuAdmin() {
            int option;
            do {
                System.out.println("Admin Dashboard");
                System.out.println("1. Add Student");
                System.out.println("2. Display Registered Students");
                System.out.println("3. Add Book");
                System.out.println("4. Logout"); // Perbaikan disini
                System.out.print("Choose option (1-4): ");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        scanner.nextLine(); // Consume newline
                        addStudent();
                        break;
                    case 2:
                        displayStudents();
                        break;
                    case 3:
                        addBook();
                        break;
                    case 4: // Perbaikan disini
                        System.out.println("Logging out from admin...");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } while (option != 4);
        }

    }
}