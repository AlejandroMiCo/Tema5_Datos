package ejem1;

import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

// import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement // Utilizado para generar un XML que representa esta clase

public class Persona {

    private int Id;
    private String nombre;
    private boolean casado;
    private String sexo;

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

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}