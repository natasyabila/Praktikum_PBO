package modul4.tugas.data;

import modul4.tugas.books.*;
import modul4.tugas.exception.custom.IllegalAdminAccess;
import modul4.tugas.util.iMenu;

import java.util.ArrayList;
import java.util.Scanner;
import static org.example.Main.studentList;

public abstract class Admin extends User implements iMenu{

    Scanner scanner = new Scanner(System.in);

    public static ArrayList<Book> daftarBuku = new ArrayList<>();
    private int i;

    public Admin() {
        super("admin");
    }

    public void login() throws IllegalAdminAccess {
        System.out.print("Masukkan Username (admin): ");
        String username = scanner.next();
        System.out.print("Masukkan Password (admin): ");
        String password = scanner.next();
        try {
            if (isAdmin(username, password)) {
                System.out.println("Login berhasil sebagai Admin");
                menu();
            }
        } catch (IllegalAdminAccess e){
            System.out.println(e.getMessage());
        }
    }

    private boolean isAdmin(String username, String password) throws IllegalAdminAccess {
        // Implementasi verifikasi admin
        if (username.equals("pahmi") && password.equals("pahmi123")){
            return true;
        } else {
            throw new IllegalAdminAccess("invalid credentials");
        }
    }

    public void menu() {
        while (true) {
            System.out.println("Menu Admin");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Input Buku");
            System.out.println("4. Tampilkan Daftar Buku");
            System.out.println("5. Logout");
            System.out.print("Pilih antara (1-5): ");
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayStudents(studentList);
                        break;
                    case 3:
                        inputBook();
                        break;
                    case 4:
                        displayBooks(daftarBuku);
                        break;
                    case 5:
                        System.out.println("Logout berhasil.");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println("kesalahan pilihan" + e.getMessage());
            }
        }
    }

    protected abstract void displayStudents(ArrayList<Student> studentList);

    @Override
    public void addStudent() {
        // Implementasi penambahan mahasiswa
        System.out.println("Menambahkan mahasiswa...");
        System.out.print("Masukkan Nama: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.next();
        scanner.nextLine();
        while(true){
            if (nim.length() != 15 ) {
                System.out.print("Nim Harus 15 Digit!!!\n");
                System.out.print("Masukkan NIM: ");
                nim = scanner.nextLine();
            } else if (checkNim(nim)){
                System.out.println("NIM sudah terdaftar");
                System.out.print("Masukkan NIM baru: ");
                nim = scanner.nextLine();
            } else {
                break;
            }
        }
        System.out.print("Masukkan Fakultas: ");
        String faculty = scanner.nextLine();
        System.out.print("Masukkan Program Studi: ");
        String studyProgram = scanner.nextLine();
        studentList.add(new Student(nim, name, faculty, studyProgram) {
            @Override
            public void displayMenu() {

            }

            @Override
            public void selectBook() {

            }

            @Override
            public void selectStoryBook(ArrayList<StoryBook> bookList) {

            }

            @Override
            public void selectBookFromList(ArrayList<Book> bookList) {

            }
        });
        System.out.println("Mahasiswa dengan NIM " + nim + " berhasil ditambahkan.");
    }

    protected abstract boolean checkNim(String nim);


    // Admin.java
    @Override
    public void inputBook() {
        // Implementasi input buku
        System.out.println("Memasukkan buku...");
        System.out.println("Pilih jenis buku:");
        System.out.println("1. History Book");
        System.out.println("2. Story Book");
        System.out.println("3. Text Book");
        System.out.print("Pilih jenis buku (1-3): ");
        int bookType = scanner.nextInt();
        scanner.nextLine();

        String idBuku, judul, author, category;
        int stok;
        System.out.print("Masukkan judul buku: ");
        judul = scanner.nextLine();
        System.out.print("Masukkan author buku: ");
        author = scanner.nextLine();
        System.out.print("Masukkan category buku: ");
        category = scanner.nextLine();
        System.out.print("Masukkan stok buku: ");
        stok = scanner.nextInt();
        scanner.nextLine();

        switch (bookType) {
            case 1:
                idBuku = generateId("HB");
                daftarBuku.add(new HistoryBook(idBuku, judul, stok, category, author));
                break;
            case 2:
                idBuku = generateId("SB");
                daftarBuku.add(new StoryBook(idBuku, judul, stok, category, author));
                break;
            case 3:
                idBuku = generateId("TB");
                daftarBuku.add(new TextBook(idBuku, judul, stok, category, author));
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }
        System.out.println("Buku berhasil ditambahkan.");
    }

    @Override
    public void displayBooks(ArrayList<Book> bookList) {
        daftarBuku.add(new StoryBook("SB32F", "Janda Loro ati", 17, "Story", "Martis"));
        daftarBuku.add(new HistoryBook("HB324", "Satu Hari", 2, "History", "Moskov"));
        daftarBuku.add(new TextBook("TB323", "Pasutri", 4, "Text", "Eudora"));
        // Implementasi menampilkan daftar buku
        System.out.println("Daftar Buku Tersedia:");
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Author || Category || Stock ||");
        int index = 1;
        for (Book book : bookList) {
            if (book != null) {
                System.out.println("|| " + index + " || " + book.getIdBuku() + " || " + book.getJudul() + " || " + book.getAuthor() + " || " + book.getCategory() + "  || " + book.getStok() + " ||");
                index++;
            }
        }
        System.out.println("================================================================");
    }


    private void displayStudents(Student[] studentList) {
        System.out.println("Daftar Mahasiswa yang terdaftar:");
        for (Student student : studentList) {
            System.out.println("\nNama: " + student.getName());
            System.out.println("NIM: " + student.getNim());
            System.out.println("Fakultas: " + student.getFaculty());
            System.out.println("Program Studi: " + student.getStudyProgram());
            if (!student.getBorrowedBooks().isEmpty()) {
                System.out.println("  Meminjam Buku:");
                for (Book book : student.getBorrowedBooks()) {
                    System.out.println("    - " + book.getJudul());
                }
            }
        }
    }

    private String generateId(String prefix) {
        // Implementasi pembuatan ID unik
        // Contoh: HB001, SB002, TB003, dst.
        int nextId = i + 1;
        return prefix + String.format("%03d", nextId);
    }
}