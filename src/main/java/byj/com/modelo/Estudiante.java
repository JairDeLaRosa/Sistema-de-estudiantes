package byj.com.modelo;

public class Estudiante {
    private int idEstudiante;
    private String noombre;
    private String apellido;
    private String telefono;
    private String email;

    public Estudiante(int idEstudiante){
        this.idEstudiante= idEstudiante;
    }
    public Estudiante(String noombre, String apellido, String telefono, String email) {
        this.noombre = noombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }
    public Estudiante(int idEstudiante, String noombre, String apellido, String telefono, String email) {
        this.idEstudiante = idEstudiante;
        this.noombre = noombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNoombre() {
        return noombre;
    }

    public void setNoombre(String noombre) {
        this.noombre = noombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante=" + idEstudiante +
                ", noombre='" + noombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
