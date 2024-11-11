package application;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class MainController {

	//mi intencion es llevar desde aqui a todas las demas ventanas que tendra nuestro programa
		//este es el border pane de mi ventana principal colocada en el borderlayoutcenter
		@FXML
	    BorderPane mainPane;
		
		//estos metodos invocan al constructor de sus clases que son un nodo fx que ce cargo
		public void P_NuevoContacto() {
			System.out.println("paso por aqui");
			PanelNuevoContactoController nuevocontacto = new PanelNuevoContactoController();
			mainPane.setCenter(nuevocontacto);
		
		}
		
		public void P_EditarContacto() {
			System.out.println("paso por aqui");
			PanelEditarContactoController editarcontacto = new PanelEditarContactoController();
			mainPane.setCenter(editarcontacto);
		}
		
		public void P_ExportarContacto() {
			System.out.println("paso por aqui");
			ExportarContactoController exportarcontacto = new ExportarContactoController();
			mainPane.setCenter(exportarcontacto);
		}
		
		public void P_Salir() {
			System.out.println("paso por aqui");
			PanelSalirController salir = new PanelSalirController();
			mainPane.setCenter(salir);
		}
		
		public void P_TodosLosContactos() {
			System.out.println("paso por aqui");
			PanelTodosLosContactosController todos = new PanelTodosLosContactosController();
			mainPane.setCenter(todos);
		}
		public void P_Favoritos() {
			System.out.println("paso por aqui");
			PanelFavoritosController favoritos = new PanelFavoritosController();
			mainPane.setCenter(favoritos);
		}
}
