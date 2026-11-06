package domain;

import dto.AutorDTO;
import dto.ComentarioDTO;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Post implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    private String id;
    private Date data;
    private String titulo;
    private String conteudo;

    private AutorDTO autor;
    private List<ComentarioDTO> comentarios = new ArrayList<>();

    public Post(){}

    public Post(String id, Date data, String titulo, String conteudo, AutorDTO autor) {
        this.id = id;
        this.data = data;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.autor = autor;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String gettitulo() {
        return titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public AutorDTO getAutor() {
        return autor;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
