module net.othmane.hd.tp_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens net.othmane.hd.tp_javafx to javafx.fxml;
    opens net.othmane.hd.tp_javafx.controller to javafx.fxml;

    exports net.othmane.hd.tp_javafx;
    exports net.othmane.hd.tp_javafx.controller;
}