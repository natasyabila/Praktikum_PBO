package org.example;
import java.util.Scanner;
// Parent class
class BangunRuang {
    protected String nama;

    public BangunRuang(String nama) {
        this.nama = nama;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    // Method untuk menginputkan atribut
    public void inputNilai() {}

    // Method untuk menghitung luas permukaan
    public void luasPermukaan() {}

    // Method untuk menghitung volume
    public void volume() {}
}

// Child class untuk bangun ruang Tabung
class Tabung extends BangunRuang {
    private double jariJari;
    private double tinggi;

    public Tabung(String nama) {
        super(nama);
    }

    @Override
    public void inputNilai() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jari-jari tabung: ");
        jariJari = input.nextDouble();
        System.out.print("Masukkan tinggi tabung: ");
        tinggi = input.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double luas = 2 * Math.PI * jariJari * (jariJari + tinggi);
        System.out.println("Luas Permukaan " + getNama() + ": " + luas);
    }

    @Override
    public void volume() {
        double volume = Math.PI * jariJari * jariJari * tinggi;
        System.out.println("Volume " + getNama() + ": " + volume);
    }
}

// Child class untuk bangun ruang Kubus
class Kubus extends BangunRuang {
    private double sisi;

    public Kubus(String nama) {
        super(nama);
    }

    @Override
    public void inputNilai() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan panjang sisi kubus: ");
        sisi = input.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double luas = 6 * sisi * sisi;
        System.out.println("Luas Permukaan " + getNama() + ": " + luas);
    }

    @Override
    public void volume() {
        double volume = sisi * sisi * sisi;
        System.out.println("Volume " + getNama() + ": " + volume);
    }
}

// Child class untuk bangun ruang Balok
class Balok extends BangunRuang {
    private double panjang;
    private double lebar;
    private double tinggi;

    public Balok(String nama) {
        super(nama);
    }

    @Override
    public void inputNilai() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan panjang balok: ");
        panjang = input.nextDouble();
        System.out.print("Masukkan lebar balok: ");
        lebar = input.nextDouble();
        System.out.print("Masukkan tinggi balok: ");
        tinggi = input.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double luas = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
        System.out.println("Luas Permukaan " + getNama() + ": " + luas);
    }

    @Override
    public void volume() {
        double volume = panjang * lebar * tinggi;
        System.out.println("Volume " + getNama() + ": " + volume);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat objek untuk masing-masing class
        Tabung tabung = new Tabung("Tabung");
        Kubus kubus = new Kubus("Kubus");
        Balok balok = new Balok("Balok");

        // Memanggil method inputNilai() untuk menginputkan atribut
        tabung.inputNilai();
        kubus.inputNilai();
        balok.inputNilai();

        // Memanggil method luasPermukaan() dan volume()
        System.out.println("\nHasil Perhitungan:");
        tabung.luasPermukaan();
        tabung.volume();
        kubus.luasPermukaan();
        kubus.volume();
        balok.luasPermukaan();
        balok.volume();
    }
}
