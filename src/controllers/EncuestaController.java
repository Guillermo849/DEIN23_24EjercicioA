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
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.Window;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import application.Main;

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
			
			// Añadir ToolTips a los Sliders
			sldCompras.setTooltip(new Tooltip("Indica de 1 al 10 cuánto te gusta ir de compras"));
			sldTelevision.setTooltip(new Tooltip("Indica de 1 al 10 cuánto te gusta ve la television"));
			sldCine.setTooltip(new Tooltip("Indica de 1 al 10 cuánto te gusta ir al cine"));
			
			// Boton Aceptar
			btnAceptar.setOnAction(i -> verInformacion());
			
			
			// Boton Cancelar para cerrar la aplicacion
			btnCancelar.setOnAction(e -> Platform.exit());
    		
		} catch (Exception e) {
			Alert alertWindows = new Alert(Alert.AlertType.ERROR);
			alertWindows.setHeaderText(null);
			alertWindows.setContentText(e.toString());
			alertWindows.showAndWait();
		}
	}
    
    /*
     * Metodo que muestra una ventana con la informacion introducida en la ventana principal
     * */
    private void verInformacion() {
    	
    	try {
    		RadioButton sexo = (RadioButton) tGroupSexo.getSelectedToggle();
    		/*
    		 * Ventana de informacion
    		 * */
    		Alert info = new Alert(Alert.AlertType.INFORMATION);
        	info.setTitle("TUS DATOS");
        	info.setHeaderText(null);
        	String mensaje = "Profesion: " + tfProfesion.getText().toString() + "\n"
        			+ "Nº de hermanos: " + tfNumHermanos.getText().toString() + "\n"
        			+ "Edad " + cmbBoxEdad.getValue().toString() + "\n"
        			+ "Sexo: " + sexo.getText() + "\n";
        	if (chbxDeporte.isSelected()) {
        		mensaje += "Deportes que practicas: \n";
        		ObservableList<String> lstDeportes = lstViewDeportes.getSelectionModel().getSelectedItems();
        		for (String d : lstDeportes) {
        			mensaje += "\t " + d + "\n";
        		}
        	}
        	
        	mensaje += "Grado de afición a las compras: " + (int)sldCompras.getValue() +"\n"
        				+ "Grado de afición a ver la televisión: " + (int)sldTelevision.getValue() +"\n"
        				+ "Grado de afición a ir al cine: " + (int)sldCine.getValue() + "\n";
        	
        	info.setContentText(mensaje);
        	info.showAndWait();
        	
    	} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
}

