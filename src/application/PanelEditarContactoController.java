package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import entidades.Contacto;
import entidades.ControladorContactos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class PanelEditarContactoController extends AnchorPane implements Initializable{
	
	@FXML
	private ListView<Contacto> lista;
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

	public ObservableList<Contacto> CargarDatos() {
		ObservableList<Contacto> con = FXCollections.observableArrayList();
		con=ControladorContactos.LeerContactos();
		return con;
	}
	@FXML
	public void ListaDeContactos() {
		System.out.println("pasa por aqui tiene los datos");
		ObservableList<Contacto> con = CargarDatos();
		lista.setVisible(true);
		lista.setItems(con);		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ListaDeContactos();		
	}
	
	@FXML
	public void BotonModificar() {
		Contacto con=null;
		if(lista.getSelectionModel().getSelectedItem()!=null) {
			 con =lista.getSelectionModel().getSelectedItem();
			Alert datos = new Alert(AlertType.CONFIRMATION);
			 datos.setContentText("Quiere cargar los datos del contacto: "+con.getNombre());
			 datos.setTitle("Modificar Contacto");
			 Optional<ButtonType> result = datos.showAndWait();
			 if(result.get()==ButtonType.OK) {
				 //aqui va el codigo que pone los textos en los respectivos campos
				 System.out.println("ha seleccionado "+con.toString());
				 campo_nombre.setText(con.getNombre());
				 
			 }		 
		}
		else {
			System.out.println("no se han cargado los datos del contacto");
		}
		
	}
	
}
