package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class PanelEditarContactoController extends AnchorPane implements Initializable{
	
	@FXML
	private ListView<Contacto> lista;
	@FXML
	private TextField campo_nombre;
	@FXML
	private TextField campo_telefono;
	@FXML
	private CheckBox esfavorito;
	@FXML
	private TextField campo_email;
	@FXML
	private RadioButton radio_masculino;
	@FXML
	private RadioButton radio_femenino;
	@FXML
	private ChoiceBox<String> grupocombo;
	@FXML
	private TextField notas_ad;
	@FXML
	private DatePicker fechanac;
	//meterunimageview
	@FXML
	private Button modificar;
	@FXML
	private Button limpiar;
	@FXML
	private Button atras;
	
	private ToggleGroup t =new ToggleGroup();
		
	public PanelEditarContactoController(){
		 System.out.println("estamos en el constructor del panel");
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("paneleditarcontacto.fxml"));

	        fxmlLoader.setRoot(this);
	        fxmlLoader.setController(this);
	        try {
	            fxmlLoader.load();
	            fechanac.getEditor().setDisable(true);
	            grupocombo.setValue("Amigos");
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
				 campo_telefono.setText(con.getTelefono());
				 campo_email.setText(con.getEmail());
				 if(con.getGenero().equalsIgnoreCase(radio_masculino.getText())) {
					 radio_masculino.setSelected(true);
					 radio_femenino.setSelected(false);
				 }
				 if(con.getGenero().equalsIgnoreCase(radio_femenino.getText())) {
					 radio_femenino.setSelected(true);
					 radio_masculino.setSelected(false);
				 }
				 notas_ad.setText(con.getNotas());
				 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				 String fec =con.getFechanac().toString();
				 fechanac.setValue(LocalDate.parse(fec, formatter));
				 boolean fav=con.isFavorito();
				 if(fav) {
					 esfavorito.setSelected(fav);
				 }
				 else {
					 esfavorito.setSelected(fav);
				 }
			 }
			 System.out.println("llega al final");
		}
		else {
			System.out.println("no se han cargado los datos del contacto");
		}		
	}
	
	@FXML
	public String GrupoGenero() {
		radio_masculino.setText("Masculino");
		radio_femenino.setText("Femenino");
		radio_masculino.setToggleGroup(t);
		 radio_femenino.setToggleGroup(t);
		 RadioButton selec = (RadioButton) t.getSelectedToggle();
		 String valor =selec.getText();
		 return valor;
	}
	
	@FXML
	 public void grupo_combobox() {
		 grupocombo.setItems(FXCollections.observableArrayList("Amigos", "Familia", "trabajo"));
		 grupocombo.setValue("Amigos");
		 handleListView();
	 }
	
	 @FXML
	 private void handleListView() {
		 grupocombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				System.out.println("Elemento seleccionado: " + newValue);
			});
		}

	 @FXML
	 public void GuardarModificacion() {
		 ObservableList<Contacto> listacontactos = FXCollections.observableArrayList();
		 listacontactos=CargarDatos();
		 Contacto con;
		 if(lista.getSelectionModel().getSelectedItem()!=null) {
			 con =lista.getSelectionModel().getSelectedItem();
			Alert datos = new Alert(AlertType.CONFIRMATION);
			 datos.setContentText("Quiere Modificar los datos del contacto: "+con.getNombre());
			 datos.setTitle("Guardar Contacto Modificado");
			 Optional<ButtonType> result = datos.showAndWait();
			 if(result.get()==ButtonType.OK) {
				 Contacto modificado=new Contacto();
				 String nombre=campo_nombre.getText();
				 String telefono =campo_telefono.getText();
				 String email=campo_email.getText();
				 boolean favorito=esfavorito.isSelected();
				 String genero=GrupoGenero();
				 String grupo=grupocombo.getValue();
				 String notasstring=notas_ad.getText();
				 LocalDate fecha = fechanac.getValue();
				 con.setNombre(nombre);
				 con.setTelefono(telefono);
				 con.setEmail(email);
				 con.setFavorito(favorito);
				 con.setGenero(genero);
				 con.setGrupo(grupo);
				 con.setNotas(notasstring);
				 con.setFechanac(fecha);
				 System.out.println("llego al final");
				lista.refresh();
				 }	 	
			 }		 
	 }
	 
	 @FXML
	 public void LimpiarCampos() {
		 Alert datos = new Alert(AlertType.CONFIRMATION);
		 datos.setContentText("¿Quiere limpiarlos campos? (esta accion no se puede revertir)");
		 datos.setTitle("Limpiar Campos");
		 Optional<ButtonType> result = datos.showAndWait();
		 if(result.get()==ButtonType.OK) {
			 campo_nombre.setText(null);
			 campo_email.setText(null);
			 campo_telefono.setText(null);
			 esfavorito.setSelected(false);
			 radio_masculino.setSelected(false);
			 radio_femenino.setSelected(false);
			 notas_ad.setText(null);
			 fechanac.setValue(null);
			 }
		 else {
			 System.out.println("el usuario deiccidio no borrar los campos");
		 }
		 }

	 
}
