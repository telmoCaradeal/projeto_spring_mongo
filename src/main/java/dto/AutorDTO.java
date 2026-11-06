package dto;

import domain.Usuario;

import java.io.Serializable;

public class AutorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;

    private AutorDTO() {}

    public AutorDTO(Usuario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
