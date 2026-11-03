package dto;

import domain.Usuario;

public class AutorDTO {

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
