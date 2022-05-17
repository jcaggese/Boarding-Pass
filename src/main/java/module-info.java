module pkg.boardingpass {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens pkg.boardingpass to javafx.fxml;
    exports pkg.boardingpass;
}