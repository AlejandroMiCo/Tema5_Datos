package ejem1;

import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

// import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement // Utilizado para generar un XML que representa esta clase

public class PersonaGal {

    private int Id;
    private String nome;
    private boolean casado;
    private String sexo;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public PersonaGal(int id, String nome, boolean casado, String sexo) {
       this.Id = id;
       this.nome = nome;
       this.casado = casado;
       this.sexo = sexo;
    }
}