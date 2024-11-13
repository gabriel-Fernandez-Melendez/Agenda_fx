package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class ExportarContactoController extends AnchorPane implements Initializable{
	
	@FXML
	public ListView<Contacto> lista;
	
	@FXML
	public Button exportar;

	public ExportarContactoController(){
		 System.out.println("estamos en el constructor del panel");
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("panelexportarcontacto.fxml"));

	        fxmlLoader.setRoot(this);
	        fxmlLoader.setController(this);

	        try {
	            fxmlLoader.load();
	            lista.refresh();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	public ObservableList<Contacto> CargarDatos() {
		ObservableList<Contacto> con = FXCollections.observableArrayList();
		con=ControladorContactos.LeerContactos();
		return con;
	}
	
	
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
	public void ExportarContacto() {
		Contacto con=null;
		if(lista.getSelectionModel().getSelectedItem()!=null) {
			con=lista.getSelectionModel().getSelectedItem();
			escribir(con);
			Alert datos = new Alert(AlertType.INFORMATION);
			 datos.setContentText("se creo el csv en la carpeta Ficheros");
			 datos.setTitle("Exito");
			 datos.showAndWait();
		}
		else {
			Alert datos = new Alert(AlertType.INFORMATION);
			 datos.setContentText("seleccione de la coleccion un contacto");
			 datos.setTitle("Exportar Contacto");
			 datos.showAndWait();			
		}
	}
	
	public static void escribir(Contacto c) {
		System.out.println("pasa por aqui ");	
		String path ="Ficheros/"+c.getNombre()+".csv";
		File fich = new File(path);
		try {
			FileWriter escritor=new FileWriter(fich);
			PrintWriter budd = new PrintWriter(escritor);
			budd.println(Formato(c));
			if(escritor!=null) {
				escritor.close();
			}
			if(budd!=null) {
				budd.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	public static String Formato(Contacto c) {
		return "nombre:" + c.getNombre() + "; telefono:" + c.getTelefono() + "; email:" + c.getEmail() + "; genero:" + c.getGenero() + "; grupo:"
				+ c.getGrupo() + "; favorito:" + c.isFavorito() + "; fechaNacimiento:" + c.getFechanac().toString();
	}
	
}
