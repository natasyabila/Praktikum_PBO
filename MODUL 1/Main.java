package tugasmodul1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class tugasmodul1 {
    public static <Scanner> void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Data user
        String adminPassword = "adminpassword";
        String nimMahasiswa = "123456789012345";

        // Input user
        System.out.print("Selamat datang di sistem login library");
        System.out.print("Silakan login:");

        System.out.print("Username: ");
        String usernameInput = input.next();

        System.out.print("Password: ");
        String passwordInput = input.next();

        // Cek login
        if (usernameInput.equals(adminUsername) && passwordInput.equals(adminPassword)) {
            System.out.print("Login berhasil sebagai admin");

        } else if (usernameInput.length() == 15 && usernameInput.equals(nimMahasiswa)) {
            System.out.print("Login berhasil sebagai mahasiswa");

        } else {
            System.out.print("Username atau password salah. Login gagal");
        }

        input.close();
    }
}
        }
                }
                }