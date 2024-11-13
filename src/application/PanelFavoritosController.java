package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entidades.Contacto;
import entidades.ControladorContactos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class PanelFavoritosController extends AnchorPane implements Initializable{
	
	@FXML
	private ListView<Contacto> lista;
	
	public PanelFavoritosController(){
		 System.out.println("estamos en el constructor del panel");
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("panelfavoritos.fxml"));
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
		lista.refresh();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ListaDeContactos();		
	}
	
}
