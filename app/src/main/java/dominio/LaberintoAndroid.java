package dominio;

import java.io.Serializable;

public class LaberintoAndroid implements Serializable{


    private String nombreLaberinto;
    private String pathImagen;
    private String descripcion;


    public LaberintoAndroid(String nombreLaberinto, String pathImagen, String descripcion) {
        this.nombreLaberinto = nombreLaberinto;
        this.pathImagen = pathImagen;
        this.descripcion = descripcion;
    }

    public String getNombreLaberinto() {
        return nombreLaberinto;
    }

    public void setNombreLaberinto(String nombreLaberinto) {
        this.nombreLaberinto = nombreLaberinto;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
