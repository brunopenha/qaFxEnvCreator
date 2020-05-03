module qaFxEnvCreator {
	// --module-path "/opt/javafx-sdk-13.0.1/lib" --add-modules javafx.controls,javafx.fxml
	
	requires java.desktop;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	exports br.nom.penha.bruno.qafxenvcreator.main;
	exports br.nom.penha.bruno.qafxenvcreator.controle;

	 // allow everyone to access classes in  via reflection
    opens br.nom.penha.bruno.qafxenvcreator.controle;
}