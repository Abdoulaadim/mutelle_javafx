module mutuelle {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires json.simple;
	requires javafx.graphics;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
