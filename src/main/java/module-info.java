module ma.saifdine.hd.tp_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens ma.saifdine.hd.tp_javafx to javafx.fxml;
    opens ma.saifdine.hd.tp_javafx.controller to javafx.fxml;

    exports ma.saifdine.hd.tp_javafx;
    exports ma.saifdine.hd.tp_javafx.controller;
}