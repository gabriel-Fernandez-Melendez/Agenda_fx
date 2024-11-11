package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entidades.Contacto;
import entidades.ControladorContactos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class PanelEditarContactoController extends AnchorPane implements Initializable{
	
	@FXML
	private ListView<String> lista;
	@FXML
	private TextField campo_nombre;
	@FXML
	private CheckBox esfavorito;
	@FXML
	private TextField campo_movil;
	@FXML
	private TextField campo_email;
	@FXML
	private RadioButton radio_masculino;
	@FXML
	private RadioButton radio_femenino;
	@FXML
	private RadioButton radio_apache;
	@FXML
	private ChoiceBox<String> grupo_;
	@FXML
	private TextField notas_ad;
	@FXML
	private DatePicker fecha_nac;
	//meterunimageview
	@FXML
	private Button modificar;
	@FXML
	private Button limpiar;
	@FXML
	private Button atras;
	
	public PanelEditarContactoController(){
		 System.out.println("estamos en el constructor del panel");
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("paneleditarcontacto.fxml"));

	        fxmlLoader.setRoot(this);
	        fxmlLoader.setController(this);

	        try {
	            fxmlLoader.load();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	
}
