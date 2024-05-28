package modul4.tugas.exception.custom;

public class IllegalAdminAccess extends Exception {
    public IllegalAdminAccess (String message){
        super(message);
    }
}