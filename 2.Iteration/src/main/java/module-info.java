module domain {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    exports presentation;
    opens presentation to javafx.fxml;
    exports domain;
    opens domain to javafx.fxml;
}