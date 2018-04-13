import java.util.Calendar;
import java.util.GregorianCalendar;


public abstract class Usuario {

	protected String nombre;
	protected String apellido;
	protected String domicilio;
	protected static Calendar fechaAlta = new GregorianCalendar();
	protected String usuario;
	protected String contrase�a;
	
	//constructor

	public Usuario(String nombre, String apellido, String domicilio, Calendar fechaAlta, String usuario,
			String contrase�a) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		Usuario.fechaAlta = fechaAlta;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}
	
	//getters-setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Calendar getFechaAlta() {
		return fechaAlta;
	}

	public static void setFechaAlta(Calendar fechaAlta) {
		Usuario.fechaAlta = fechaAlta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}	

	//metodos
	
}
