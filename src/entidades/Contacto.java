package entidades;

import java.time.LocalDate;

public class Contacto {

	private String nombre;
	private String telefono;
	private String email;
	private String genero;
	private String grupo;
	private boolean favorito;
	private String notas;
	private LocalDate fechanac;
	
	public Contacto() {
		
	}
	
	public Contacto(String nombre, String telefono, String email, String genero, String grupo, boolean favorito,
			String notas, LocalDate fechanac) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.genero = genero;
		this.grupo = grupo;
		this.favorito = favorito;
		this.notas = notas;
		this.fechanac = fechanac;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public LocalDate getFechanac() {
		return fechanac;
	}

	public void setFechanac(LocalDate fechanac) {
		this.fechanac = fechanac;
	}

	//forma en la que almaceno los contactos
	@Override
	public String toString() {
		return " "+ getNombre()+" "+getTelefono()+" "+getEmail()+" "+getGenero()+" "+getGrupo()+" "+isFavorito()+" "+getNotas()+" "+getFechanac().toString()+" \n";
	}
	
}
