module Tugas_6_JavaFX{

    requires javafx.controls;
    requires javafx.fxml;


    opens books to javafx.base;

    exports books;

    opens com.main to javafx.fxml;
    exports com.main;

}