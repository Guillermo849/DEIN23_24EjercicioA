package controllers;

/*
 * En este programa aremos referencia a los objetos del archivo FXML y les
 *     añadiremos acciones a los que lo necesiten
 * */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class EncuestaController implements Initializable {

    @FXML
    private BorderPane root;

    @FXML
    private TextField tfProfesion;

    @FXML
    private ListView<String> lstViewDeportes;

    @FXML
    private TextField tfNumHermanos;

    @FXML
    private ComboBox<String> cmbBoxEdad;

    @FXML
    private RadioButton btnHombre;

    @FXML
    private ToggleGroup tGroupSexo;

    @FXML
    private RadioButton btnMujer;

    @FXML
    private RadioButton btnOtro;

    @FXML
    private CheckBox chbxDeporte;

    @FXML
    private Slider sldCompras;

    @FXML
    private Slider sldTelevision;

    @FXML
    private Slider sldCine;

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;
    
    private ObservableList<String> obLstEdades = FXCollections.observableArrayList("Tenis", "Futbol", 
    																			"Baloncesto", "Natación", 
    																			"Ciclismo", "Otro");

    @Override
	public void initialize(URL url, ResourceBundle rBun) {
		
		try {
    		// Añadimos contenido al ComboBox Edad
			cmbBoxEdad.getItems().addAll("Menores de 18"
    		, "Entre 18 y 30"
    		, "Entre 31 y 50"
    		, "Entre 51 y 70"
    		, "Mayores de 70");
			
			// Añadimos contenido al lstViewDeportes
			lstViewDeportes.getItems().addAll(obLstEdades);
			
			// Para que los Sliders no se queden entre dos numeros
			sldCompras.valueProperty().addListener((obs, valViejo, nuevoVal) -> 
		    sldCompras.setValue(nuevoVal.intValue()));
			
			sldTelevision.valueProperty().addListener((obs, valViejo, nuevoVal) ->
			sldTelevision.setValue(nuevoVal.intValue()));
			
			sldCine.valueProperty().addListener((obs, valViejo, nuevoVal) ->
			sldCine.setValue(nuevoVal.intValue()));
			
			
			
    		
		} catch (Exception e) {
			Alert alertWindows = new Alert(Alert.AlertType.ERROR);
			alertWindows.setHeaderText(null);
			alertWindows.setContentText(e.toString());
			alertWindows.showAndWait();
		}
	}
}

