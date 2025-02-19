package ejem1;

public class Deportista {
    private int Id;
    private String nombre;
    private String deporte;
    private boolean activo;
    private String genero;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Deportista() {
        super();
    }

    public Deportista(int id, String nombre, String deporte, boolean activo, String genero) {
        super();
        this.Id = id;
        this.nombre = nombre;
        this.deporte = deporte;
        this.activo = activo;
        this.genero = genero;
    }
}
