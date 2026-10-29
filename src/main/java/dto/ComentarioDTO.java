package dto;

import java.util.Date;

public class ComentarioDTO {

    private String texto;
    private Date data;
    private AutorDTO autorDTO;

    public ComentarioDTO() {}

    public ComentarioDTO(String texto, Date data, AutorDTO autorDTO) {
        this.texto = texto;
        this.data = data;
        this.autorDTO = autorDTO;
    }
}
