package domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Postagem implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    private String id;
    private Date data;
    private String titullo;
    private String conteudo;

    public Postagem(){}

    public Postagem(String id, Date data, String titullo, String conteudo) {
        this.id = id;
        this.data = data;
        this.titullo = titullo;
        this.conteudo = conteudo;
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

    public String getTitullo() {
        return titullo;
    }

    public void setTitullo(String titullo) {
        this.titullo = titullo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Postagem postagem = (Postagem) o;
        return Objects.equals(id, postagem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
