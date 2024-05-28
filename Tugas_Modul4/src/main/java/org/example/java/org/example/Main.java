package org.example.java.org.example;

import modul4.tugas.books.*;
import modul4.tugas.data.Admin;
import modul4.tugas.data.Student;
import modul4.tugas.exception.custom.IllegalAdminAccess;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class LibrarySystem {

    // menyimpan semua object dalam satu array dengan teknik polymorphism
    public static ArrayList<Book> daftarBuku = new ArrayList<>(); // array satu dimensi untuk menyimpan buku
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static int i = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        studentList.addFirst(new Student("202310370311041", "bila", "Teknik", "Informatika") {
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

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih antara (1-3): ");
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Masukkan NIM : ");
                        String nimStudent = scanner.next();
                        scanner.nextLine();
                        while (true) {
                            if (nimStudent.length() != 15) {
                                System.out.print("Nim Harus 15 Digit!!!\n");
                                System.out.print("Masukkan NIM : ");
                                nimStudent = scanner.nextLine();

                            } else if (checkNim(nimStudent)) {
                                Student student = new Student(nimStudent) {
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
                                };
                                student.login();
                                break;
                            } else {
                                System.out.println("Nim tidak terdaftar!");
                                break;
                            }
                        }
                        break;
                    case 2:
                        Admin admin = new Admin() {
                            @Override
                            protected void displayStudents(ArrayList<Student> studentList) {

                            }

                            @Override
                            protected boolean checkNim(String nim) {
                                return false;
                            }

                            @Override
                            public void displayMenu() {

                            }

                            @Override
                            public void displayBorrowedBooks() {

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
                        };
                        admin.login();
                        break;
                    case 3:
                        System.out.println("Terimakasih");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("kesalahan pilihan");
                scanner.nextLine();
            } catch (IllegalAdminAccess e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("kesalahan pilihan" + e.getMessage());
            }
        }
    }
    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}