module ca.j0e.dicegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.j0e.dicegame to javafx.fxml;
    exports ca.j0e.dicegame;
}
