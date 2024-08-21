package Bean;

public class ContactoBean {
	private int idContacto;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String telefonoTipo;
    private String email;  
    private String emailTipo;
    private String imagen;

    public ContactoBean() {
    }

    
    public String getTelefonoTipo() {
		return telefonoTipo;
	}


	public void setTelefonoTipo(String telefonoTipo) {
		this.telefonoTipo = telefonoTipo;
	}


	public String getEmailTipo() {
		return emailTipo;
	}


	public void setEmailTipo(String emailTipo) {
		this.emailTipo = emailTipo;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    } 
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
