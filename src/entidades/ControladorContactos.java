package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControladorContactos {
	
	public static void escribir(Contacto c) {
		System.out.println("pasa por aqui ");	
		String path ="Ficheros/ficheronuevocontacto.txt";
		File fich = new File(path);
		try {
			FileWriter escritor=new FileWriter(fich,true);
			PrintWriter budd = new PrintWriter(escritor);
			budd.println(c.toString());
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
	//tengo que hacer que las notas adicionales se pongan juntas
	public static ObservableList<Contacto> LeerContactos(){
		ObservableList<Contacto> contactos = FXCollections.observableArrayList();
		Contacto con;
		boolean fav;
		String direc = "Ficheros/ficheronuevocontacto.txt";
		File fichero = new File(direc);
		FileReader lector = null;		
		BufferedReader buffer = null;
		System.out.println("EENTERGIUJWENRTIUWRNVBIURTBNWRIBVRB");
		try {
			lector= new FileReader(fichero);
			buffer= new BufferedReader(lector);
			String info;
			while((info = buffer.readLine()) != null){
				String[] contacto = info.split("\\s+");
				String nombre = String.valueOf(contacto[1]);
				String telefono = String.valueOf(contacto[2]);
				String email = String.valueOf(contacto[3]);
				String genero = String.valueOf(contacto[4]);
				String grupo = String.valueOf(contacto[5]);
				String esfav = String.valueOf(contacto[6]);
				if(esfav.equalsIgnoreCase("true")) {
					fav=true;
				}
				else {
					fav=false;
				}
				String notas_ad = String.valueOf(contacto[7]);
				String fechanac = String.valueOf(contacto[8]);
				LocalDate fecha = LocalDate.parse(fechanac);
				con=new Contacto(nombre,telefono,email,genero,grupo,fav,notas_ad,fecha);
				contactos.add(con);					
			}
			 buffer.close();
		     lector.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return contactos;
	}
	
	public static ObservableList<Contacto> LeerContactosFavoritos(){
		ObservableList<Contacto> contactos = FXCollections.observableArrayList();
		Contacto con;
		boolean fav;
		String direc = "Ficheros/ficheronuevocontacto.txt";
		File fichero = new File(direc);
		FileReader lector = null;		
		BufferedReader buffer = null;
		System.out.println("EENTERGIUJWENRTIUWRNVBIURTBNWRIBVRB");
		try {
			lector= new FileReader(fichero);
			buffer= new BufferedReader(lector);
			String info;
			while((info = buffer.readLine()) != null){
				String[] contacto = info.split("\\s+");
				if(String.valueOf(contacto[6]).equalsIgnoreCase("true")){
				String nombre = String.valueOf(contacto[1]);
				String telefono = String.valueOf(contacto[2]);
				String email = String.valueOf(contacto[3]);
				String genero = String.valueOf(contacto[4]);
				String grupo = String.valueOf(contacto[5]);
				String esfav = String.valueOf(contacto[6]);
				if(esfav.equalsIgnoreCase("true")) {
					fav=true;
				}
				else {
					fav=false;
				}
				String notas_ad = String.valueOf(contacto[7]);
				String fechanac = String.valueOf(contacto[8]);
				LocalDate fecha = LocalDate.parse(fechanac);
				con=new Contacto(nombre,telefono,email,genero,grupo,fav,notas_ad,fecha);
				contactos.add(con);		
				}								
			}
			 buffer.close();
		     lector.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return contactos;
	}
	
	public static String NotasAdicionales(String notas) {
		notas=notas.replaceAll("\\s", "");
		return notas;
	}
}
